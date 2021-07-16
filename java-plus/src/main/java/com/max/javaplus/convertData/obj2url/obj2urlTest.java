package com.max.javaplus.convertData.obj2url;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className obj2urlTest
 * @date 2021/4/27 14:56
 * @desc 对象转URL 参数
 **/
@Slf4j
public class obj2urlTest {


    public static void main(String[] args) {
/*
        JSONObject jsonObject = JSONObject.parseObject("123456");
        System.out.println(jsonObject);
*/


        String baseUrl = "https://api.pcaex.com/wms/order";

        QueryParam param = new QueryParam(Collections.singletonList("STL123457"), Arrays.asList("1487814", "1487815"), true);
        List<Info> infos = new ArrayList<>(8);
        infos.add(new Info(1, 10));
        infos.add(new Info(2, 20));
        param.setInfos(infos);

        String urlParam = param2paramStr(param);
        System.out.println("url: " + baseUrl + "?" + urlParam);
    }

    /**
     * 将Object 转成Url参数
     * ver1.0
     * 用JSONObject处理
     */
    public static String param2paramStr(Object obj) {
        String json = JSON.toJSONString(obj);
        JSONObject jsonObject = JSON.parseObject(json);
        StringBuilder result = new StringBuilder();
//        HashMap<String, String> param = new HashMap<>();
        List<UrlParam> param = new ArrayList<>();
        if (null == jsonObject) {
            return "";
        }
        Object[] keys = jsonObject.keySet().toArray();
        Arrays.stream(keys).forEach(key -> {
            Object value = jsonObject.get(key);
            if (value instanceof JSONArray) {
                JSONArray jsonArray = ((JSONArray) value);
                // 如果数组中元素为String
                if (jsonArray.stream().findFirst().get() instanceof String) {
                    jsonArray.forEach(info -> {
                        param.add(new UrlParam(key + "[]", info.toString()));
                    });
                }
            } else {
                param.add(
                        new UrlParam((String) key, value.toString())
                );
            }
        });
        try {
            result = new StringBuilder(param.stream().map(p -> p.getKey() + "=" + p.getValue()).collect(Collectors.joining("&")));
        } catch (Exception e) {
            log.error(e.getMessage());
        }
        return result.toString().replaceAll("\\+", "%20");
    }


    @Data
    @AllArgsConstructor
    public static class UrlParam {
        public String key;
        public String value;
    }


    @Data
    @NoArgsConstructor
    public static class QueryParam {
        public QueryParam(List<String> no, List<String> id, Boolean full) {
            this.no = no;
            this.id = id;
            this.full = full;
        }

        /**
         * 参考单号
         **/
        private List<String> no = new ArrayList<>(8);
        /**
         * 入库单号
         **/
        private List<String> id = new ArrayList<>(8);
        /**
         * 是否显示详情
         **/
        private Boolean full = true;

        private List<Info> infos = new ArrayList<>(8);
    }

    @Data
    @AllArgsConstructor
    public static class Info {
        private Integer num;
        private Integer price;
    }
}
