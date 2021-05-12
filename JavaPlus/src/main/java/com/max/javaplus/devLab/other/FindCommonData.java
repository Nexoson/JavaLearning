package com.max.javaplus.devLab.other;


import java.util.*;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className FindCommonData
 * @date 2021/5/12 10:06
 * @desc 数据库字段求同存异
 **/
public class FindCommonData {

    public static void main(String[] args) {

        Map<String, List<String>> initData = getInitData();


        // 存储所有字段(去重)
        Set<String> allFields = new HashSet<>();
        List<String> realCommonFields = new ArrayList<>();
        // 标准通用字段
        List<String> commonFields = new ArrayList<>(Arrays.asList("id", "name", "enabled", "sandbox", "creator", "create_date", "updater", "update_date", "dept_id", "register_date"));
        // 所有鉴权字段
        List<String> authFields = Arrays.asList("client_id", "client_secret", "app_key", "app_secret", "token", "refresh_token");


        // key集合
        List<String> keys = new ArrayList<>(initData.keySet());

        // 统计并集次数
        int nums = 0;

        for (int i = 0; i < keys.size(); i++) {
            List<String> tableFields = initData.get(keys.get(i));
            // 求所有字段组合(并集)
            for (String s : tableFields) {
                allFields.add(s);
            }
            // 求通用字段组合(交集)
            if (i != 0) {
                realCommonFields.retainAll(tableFields);
                nums++;
            }
            if (i == 0) {
                realCommonFields.addAll(tableFields);
            }
        }

        System.out.println("并集次数: " + nums);
        System.out.println("并集数据,长度: " + allFields.size());
        allFields.stream().forEach(str -> System.out.println(str));

        System.out.println("交集数据");
        realCommonFields.stream().forEach(str -> System.out.println(str));


        Map<String, List<String>> resultMap = new HashMap<>();
        // 根据交集数据 筛选出每个物流平台特有字段
        for (int i = 0; i < keys.size(); i++) {
            List<String> tableFields = initData.get(keys.get(i));
            /*----------------筛选出缺失的公共字段-------------------*/
/*            tableFields.removeAll(realCommonFields);
            tableFields.retainAll(commonFields);*/

            /*----------------筛选出本表特有字段-------------------*/
            tableFields.removeAll(commonFields);
            tableFields.removeAll(authFields);

            /*----------------筛选出已有的授权字段-------------------*/
//            tableFields.retainAll(authFields);
            resultMap.put(keys.get(i), tableFields);
        }
        System.out.println("--------------------结果------------------------");

        for (String key : resultMap.keySet()) {
            System.out.println(key + ": " + resultMap.get(key).toString());
        }


    }

    private static Map<String, List<String>> getInitData() {
//        List<List<String>> topData = new ArrayList<>(16);
        Map<String, List<String>> initData = new HashMap<>(16);
        String alljoy = "id,name,app_token,app_key,enabled,sandbox,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("alljoy", new ArrayList(Arrays.asList(alljoy.split(","))));

        String anjun = "id,company_id,name,api_user,token,creator,create_date,enabled,sandbox,dept_id";
        initData.put("anjun", new ArrayList(Arrays.asList(anjun.split(","))));

        String beirui = "id,name,account_type,password,code,token,creator,create_date,enabled,sandbox";
        initData.put("beirui", new ArrayList(Arrays.asList(beirui.split(","))));

        String buylogic = "id,name,token,enabled,sandbox,client_id,client_secret,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("buylogic", new ArrayList(Arrays.asList(buylogic.split(","))));

        String chukouyi = "id,name,accounttype,password,api_key,token,creator,create_date,enabled,sandbox";
        initData.put("chukouyi", new ArrayList(Arrays.asList(chukouyi.split(","))));

        String etower = "id,account_type,user_id,account_number,password,license_number,token,secret_access_key,creator,create_date,enabled,sandbox";
        initData.put("etower", new ArrayList(Arrays.asList(etower.split(","))));

        String hanrun = "id,name,app_key,app_secret,token,register_date,enabled,sandbox,client_id,client_secret,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("hanrun", new ArrayList(Arrays.asList(hanrun.split(","))));

        String huahan = "id,name,accounttype,password,app_key,app_token,creator,create_date,enabled,sandbox";
        initData.put("huahan", new ArrayList(Arrays.asList(huahan.split(","))));

        String royalmail = "id,name,password,account_number,license_number,token,enabled,sandbox,client_id,client_secret,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("royalmail", new ArrayList(Arrays.asList(royalmail.split(","))));

        String santai = "id,name,user_id,app_key,token,enabled,sandbox,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("santai", new ArrayList(Arrays.asList(santai.split(","))));

        String sf_international = "id,name,head,checkword,enabled,sandbox,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("sf_international", new ArrayList(Arrays.asList(sf_international.split(","))));

        String shihang = "id,company_id,name,app_token,app_key,enabled,sandbox,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("shihang", new ArrayList(Arrays.asList(shihang.split(","))));

        String speedpak = "id,name,token,enabled,sandbox,creator,create_date,updater,update_date,deverloper_id,secret";
        initData.put("speedpak", new ArrayList(Arrays.asList(speedpak.split(","))));

        String wanexpress = "id,name,account_no,token,nounce,enabled,sandbox,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("wanexpress", new ArrayList(Arrays.asList(wanexpress.split(","))));

        String yanwen = "id,name,app_key,app_secret,token,register_date,enabled,sandbox,client_id,client_secret,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("yanwen", new ArrayList(Arrays.asList(yanwen.split(","))));

        String yunexpress = "id,name,customer_number,api_secret,token,enabled,sandbox,client_id,client_secret,creator,create_date,updater,update_date,platform,dept_id";
        initData.put("yunexpress", new ArrayList(Arrays.asList(yunexpress.split(","))));

        String fpx = "id,name,app_key,app_secret,customer_code,token,registra_date,enabled,sandbox,creator,create_date,updater,update_date,dept_id";
        initData.put("fpx", new ArrayList(Arrays.asList(fpx.split(","))));

        String winit = "id,dept_id,name,app_key,token,registra_date,enabled,sandbox,client_id,client_secret,creator,create_date,updater,update_date,application_code";
        initData.put("winit", new ArrayList(Arrays.asList(winit.split(","))));

        return initData;
    }

}
