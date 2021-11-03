package com.example.springcore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className TestServiceImpl
 * @date 2021/11/2 15:27
 * @desc 测试服务层
 **/


@Service("testService")
@Slf4j
public class TestServiceImpl implements TestService {

    @Override
    public String getInfo(String id) throws InterruptedException {
        log.info("id: " + id);
        Thread.sleep(1500);
        return "hello world!";
    }
}
