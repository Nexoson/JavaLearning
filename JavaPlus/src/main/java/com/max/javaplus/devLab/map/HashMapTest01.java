package com.max.javaplus.devLab.map;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className HashMapTest01
 * @date 2021/4/23 16:46
 * @desc
 **/
@Slf4j
public class HashMapTest01 {

    /**
     * map 取 key为null
     **/
    @Test
    public void test01() {
        String str = statusData.get(null);
        log.info("str: " + str);

        Integer num = 8;
        Integer.valueOf(8);

    }

    public static final Map<String, String> statusData = new HashMap<String, String>() {{
        put("DR", "草稿");
        put("OD", "已下单");
        put("RE", "已收货");
        put("TS", "运输中");
        put("EWC", "已到仓");
        put("PS", "部分上架");
        put("SHD", "已上架");
        put("VO", "作废");
        put("STOP", "中止");
        put("SB", "已提交");
    }};
}
