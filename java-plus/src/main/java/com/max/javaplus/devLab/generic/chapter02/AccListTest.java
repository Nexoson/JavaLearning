package com.max.javaplus.devLab.generic.chapter02;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className AccListTest
 * @date 2021/8/5 19:29
 * @desc 集合元素累加计算
 **/
public class AccListTest {

    /**
     * 将list,按id顺序组合数量 >= demand, 每次组合首位只能用一次
     **/
    @Test
    public void test01() {
        int demand = 1200;
        List<Data> initData = getInitData();
        Map<Long, List<Data>> result = new HashMap<>(8);

        for (int i = 0; i < initData.size(); i++) {
            List<Data> tempData = new ArrayList<>();
            int accNum = 0;
            for (int j = i; j < initData.size(); j++) {
                if (accNum < 1200) {
                    accNum += initData.get(j).getQty();
                    tempData.add(initData.get(j));
                } else {
                    break;
                }
            }
            result.put(tempData.stream().findFirst().get().getId(), tempData);
//            tempData.clear();
        }

        System.out.println();
        for (Long key : result.keySet()) {
            System.out.println(key + ": " + result.get(key).toString());
        }

    }

    private List<Data> getInitData() {
        List<Data> list = new ArrayList<>();
        list.add(new Data(1L, 500));
        list.add(new Data(2L, 600));
        list.add(new Data(3L, 700));
        list.add(new Data(4L, 800));
        list.add(new Data(5L, 900));
        list.add(new Data(6L, 800));
        list.add(new Data(7L, 700));
        list.add(new Data(8L, 600));
        list.add(new Data(9L, 400));
        list.add(new Data(10L, 300));
        list.add(new Data(11L, 200));
        list.add(new Data(12L, 450));
        list.add(new Data(13L, 650));
        list.add(new Data(14L, 750));
        list.add(new Data(15L, 1000));
        return list;
    }


    @lombok.Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        /**
         * 主键
         **/
        private Long id;
        /**
         * 数量
         **/
        private Integer qty;
    }

}
