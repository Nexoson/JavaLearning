package com.max.javaplus.container.map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className HashMapTest01
 * @date 2021/4/23 16:46
 * @desc HashMap学习
 **/
@Slf4j
public class HashMapTest {


    public static void main(String[] args) {

        for (int i = 0; i < 12048; i++) {

//            map.put(aaa, i);
            if (i == 2048 - 2) {
                System.out.println();
            }
        }

        System.out.println();
/*        for (String key : map.keySet()) {
            System.out.println("key: " + key + " value: " + map.get(key));
        }*/
    }

    /**
     * HashMap初始化
     **/
    @Test
    public void test01() {
        Map<String, Integer> map = new HashMap<>(16);
/*        if (initialCapacity < 0)
            throw new IllegalArgumentException("Illegal initial capacity: " +
                    initialCapacity);
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;
        if (loadFactor <= 0 || Float.isNaN(loadFactor))
            throw new IllegalArgumentException("Illegal load factor: " +
                    loadFactor);
        this.loadFactor = loadFactor;
        this.threshold = tableSizeFor(initialCapacity);*/

        /**
         * HashMap初始化
         * 1. 校验初始容量 initialCapacity
         * 2. 初始化 加载因子(默认0.75)  长度超过3/4就会扩容
         * 3. 初始化容量 tableSizeFor(),通过 | (按位或运算) 求出不小于 initialCapacity 最小的2的幂次方
         **/
    }

    @Test
    public void test02() {
/*        HashMap<Integer, Integer> map = new HashMap<>(8);
        for (int i = 0; i < 1000; i++) {
            map.put(i, i * i);
        }
//        map.putIfAbsent(1, 150);

        System.out.println();
        for (Integer key : map.keySet()) {
            System.out.println("key: " + key + " value: " + map.get(key));
        }*/
//        public V put(K key, V value) {
//            return putVal(hash(key), key, value, false, true);
//        }


    }


    /**
     * 查找hash碰撞的字符(2char)
     **/
    @Test
    public void test03() {

        List<Node> nodes = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();

        HashMap<String, Integer> map = new HashMap<>(64);
        String chars = "abcdefghijklmnopqrstuvwxyz";
        String key = null;
        for (int i = 0; i < 1000; i++) {
            char c1 = chars.charAt((int) (Math.random() * 26));
            char c2 = chars.charAt((int) (Math.random() * 26));
            char[] arr = {c1, c2};
            key = new String(arr);
            int h;
            int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            hashSet.add(hash);
        }

        for (int i = 0; i < 1000; i++) {
            char c1 = chars.charAt((int) (Math.random() * 26));
            char c2 = chars.charAt((int) (Math.random() * 26));
            char[] arr = {c1, c2};
            key = new String(arr);
            int h;
            int hash = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
            if (hashSet.contains(hash)) {
                nodes.add(new Node(key, hash));
            }
        }

        Map<Integer, List<String>> result = new HashMap<>(128);

        for (Node obj : nodes) {
            if (result.keySet().contains(obj.getHash())) {
                List<String> list = result.get(obj.getHash());
                list.add(obj.getKey());
            } else {
                ArrayList<String> strs = new ArrayList<>();
                strs.add(obj.getKey());
                result.put(obj.getHash(), strs);
            }
        }


        Iterator<Map.Entry<Integer, List<String>>> iterator = result.entrySet().iterator();

        while (iterator.hasNext()) {
            Integer resKey = iterator.next().getKey();
            if(result.get(resKey).size() == 1){
                iterator.remove();
            }
        }

        System.out.println(result.size());

    }

    @AllArgsConstructor
    @Data
    public class Node {
        private String key;
        private Integer hash;
    }

    /**
     * map 取 key为null
     **/
    @Test
    public void test08() {
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
