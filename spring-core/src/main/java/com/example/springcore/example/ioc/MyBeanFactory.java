package com.example.springcore.example.ioc;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className BeanFactory
 * @date 2021/11/5 17:15
 * @desc bean工厂(山寨IOC容器)  https://blog.csdn.net/weixin_43907422/article/details/105933374
 **/
public class MyBeanFactory {
    /**
     * 配置对象(类比spring IOC容器中的Bean定义注册表)
     **/
    private static final Properties props;
    /**
     * 保存创建好对象的容器,与类名组成key-value对(类比spring IOC容器中的Bean缓存池)
     **/
    private static Map<String, Object> beans;

    static {
        props = new Properties();
        // 通过类加载器读入配置文件
        InputStream in = MyBeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");

        try {
            // 加载配置文件到配置对象
            props.load(in);
            // 初始化容器
            beans = new HashMap<>();
            Enumeration<Object> keys = props.keys();
            // 循环遍历配置对象中的所有类名(key)
            while (keys.hasMoreElements()) {
                String key = keys.nextElement().toString();
                // 通过类名拿到全类名(value)
                String beanPath = props.getProperty(key);
                // 利用全类名反射创建对象
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();
                // 将对象放入容器中
                beans.put(key, value);
            }
        } catch (IOException e) {
            throw new ExceptionInInitializerError("初始化properties失败！程序终止！");
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Object getBean(String beanName) {
        // 从容器中获取对象
        return beans.get(beanName);
    }

}
