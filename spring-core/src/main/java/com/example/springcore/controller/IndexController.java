package com.example.springcore.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className IndexController
 * @date 2021/11/8 15:06
 * @desc 玩转分布式锁
 **/
@RestController
@RequestMapping("index")
@Api(tags = "分布式锁")
@Slf4j
public class IndexController {

    @Resource
    private Redisson redisson;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    /**
     * 秒杀(并发减库存)
     * 单体应用互斥锁,可解决并发问题,不会超卖
     *
     * @return null
     * @author huangX
     * @date 15:09 2021/11/8
     **/
//    @GetMapping("stock/deduct")
    public String deductStock01() {
        // 单体服务可以控制
        synchronized (this) {
            try {
                // 获取 redis 中的库存
                int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
                if (stock > 0) {
                    int realStock = stock - 1;
                    stringRedisTemplate.opsForValue().set("stock", realStock + "");
                    log.info("扣减成功, 剩余库存: " + realStock);
                } else {
                    log.info("扣减失败, 库存不足");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return "end";
        }
    }

    /**
     * 简易版
     **/
//    @GetMapping("stock/deduct")
    public String deductStock02() {
        // 商品id
        String lockKey = "product_001";
        // 唯一标识, 每个线程只能删除自己的锁 (UUID重复概率忽略不计)
        String clientId = UUID.randomUUID().toString();
        try {
            // 底层调用setnx(key,value),设置key超时时间,锁
            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
            // 开启辅助线程,定时(锁时间1/3左右)定时去刷新锁的存活时间, 以解决业务代码未执行完,但是锁就失效了
/*            Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, "success");
            stringRedisTemplate.expire(lockKey,10, TimeUnit.SECONDS);*/

            if (!result) {
                return "当前人数过多";
            }
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                log.info("扣减成功, 剩余库存: " + realStock);
            } else {
                log.info("扣减失败, 库存不足");
            }
        } finally {
            // 释放锁
            if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                stringRedisTemplate.delete(lockKey);
            }

        }
        return "end";
    }


    /**
     * 用Redisson实现分布式锁
     * 问题1 如果临时要求提升10倍性能,代码如何优化
     * 解决: 对应商品库存比如为1000, 则分十组 用productId_1 -> productId_10, 即分段锁的概念, 参考CurrentHashMap底层原理
     *
     * 问题2 如果redis集群或者主从架构, 主从节点正在同步时,主节点宕机,则会丢失锁信息
     * 解决: 1.用zookeeper保证CP(一致性和分区容错性) 2.redlock(不推荐)
     **/
    @GetMapping("stock/deduct")
    public String deductStock03() {
        /**
         * CAP原则又称CAP定理，指的是在一个分布式系统中，一致性（Consistency）、可用性（Availability）、分区容错性（Partition tolerance）。
         * CAP 原则指的是，这三个要素最多只能同时实现两点，不可能三者兼顾。
         **/

        // 商品id
        String lockKey = "product_001";
        String clientId = UUID.randomUUID().toString();
        RLock redLock = redisson.getLock(lockKey);
        try {
            redLock.lock(30,TimeUnit.SECONDS);
            int stockNum = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stockNum > 0) {
                int realStock = stockNum - 1;
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                log.info("扣减成功, 剩余库存: " + realStock);
            } else {
                log.info("扣减失败, 库存不足");
            }
        } finally {
            redLock.unlock();
        }
        return "end";
    }
}
