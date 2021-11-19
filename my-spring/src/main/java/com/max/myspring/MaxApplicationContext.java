package com.max.myspring;

import com.max.myspring.annotation.Autowired;
import com.max.myspring.annotation.Component;
import com.max.myspring.annotation.ComponentScan;
import com.max.myspring.annotation.Scope;
import com.max.myspring.inter.BeanNameAware;
import com.max.myspring.inter.BeanPostProcessor;
import com.max.myspring.inter.InitializingBean;

import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className MaxApplicationContext
 * @date 2021/11/18 15:22
 * @desc 自定义Spring容器
 **/
public class MaxApplicationContext {

    private Class<com.max.myspring.config.AppConfig> configClass;

    /**
     * 单例池
     **/
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    /**
     * 存储所有数据
     **/
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    private List<BeanPostProcessor> beanPostProcessorList = new ArrayList<>();

    public MaxApplicationContext(Class<com.max.myspring.config.AppConfig> configClass) {
        this.configClass = configClass;
        // 解析配置类
        // ComponentScan注解 --> 扫描路径 --> 扫描类
        scanBean(configClass);
        for (String beanName : beanDefinitionMap.keySet()) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                Object bean = createBean(beanName, beanDefinition);
                singletonObjects.put(beanName, bean);
            }
        }
    }

    /**
     * 创建bean
     **/
    public Object createBean(String beanName, BeanDefinition beanDefinition) {
        Class clazz = beanDefinition.getClazz();
        try {
            Object instance = clazz.getDeclaredConstructor().newInstance();
            // 依赖注入(简易)
            for (Field declaredField : clazz.getDeclaredFields()) {
                if (declaredField.isAnnotationPresent(Autowired.class)) {
                    // 获取bean
                    Object bean = getBean(declaredField.getName());
                    if (null == bean) {
                        throw new NullPointerException();
                    } else {
                        declaredField.setAccessible(true);
                        declaredField.set(instance, bean);
                    }
                }
            }
            // Aware回调
            if (instance instanceof BeanNameAware) {
                ((BeanNameAware) instance).setBeanName(beanName);
            }

            // 初始化前
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessBeforeInitialization(instance, beanName);
            }

            // 初始化
            if (instance instanceof InitializingBean) {
                ((InitializingBean) instance).afterPropertiesSet();
            }

            // 初始化后
            for (BeanPostProcessor beanPostProcessor : beanPostProcessorList) {
                instance = beanPostProcessor.postProcessAfterInitialization(instance, beanName);
            }
            return instance;

            // BeanPostProcessor(Bean实例化前后处理)

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取bean
     **/
    public Object getBean(String beanName) {
        if (beanDefinitionMap.containsKey(beanName)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get(beanName);
            if (beanDefinition.getScope().equals("singleton")) {
                Object o = singletonObjects.get(beanName);
                return o;
            } else {
                // 创建Bean 对象
                return createBean(beanName, beanDefinition);
            }
        } else {
            // 不存在对应的Bean
            throw new NullPointerException();
        }
    }

    /**
     * 扫描
     **/
    private void scanBean(Class<com.max.myspring.config.AppConfig> configClass) {
        ComponentScan componentScanAnnotation = (ComponentScan) configClass.getDeclaredAnnotation(ComponentScan.class);
        // 找到扫描路径
        String path = componentScanAnnotation.value();
        path = path.replace(".", "/");
//        System.out.println(path);

        // 根据路径
        // Bootstrap --> jre/lib
        // Ext --------> jre/ext/lib
        // App --------> classpath --> target
        // app
        ClassLoader classLoader = MaxApplicationContext.class.getClassLoader();
        URL resource = classLoader.getResource(path);
        File file = new File(resource.getFile());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                String fileName = f.getAbsolutePath();
                // 是类文件才往下走
                if (fileName.endsWith(".class")) {
//                    System.out.println(f);
                    String className = fileName.substring(fileName.indexOf("com"), fileName.indexOf(".class"));
                    className = className.replace("\\", ".");
                    try {
                        Class<?> clazz = classLoader.loadClass(className);
                        if (clazz.isAnnotationPresent(Component.class)) {
                            // 表示当前这个类是一个Bean
                            // 解析类  BeanDefinition
                            Component componentAnnotation = clazz.getDeclaredAnnotation(Component.class);

                            if (BeanPostProcessor.class.isAssignableFrom(clazz)) {
                                BeanPostProcessor instance = (BeanPostProcessor) clazz.getDeclaredConstructor().newInstance();
                                beanPostProcessorList.add(instance);
                            }

                            String beanName = componentAnnotation.value();

                            BeanDefinition beanDefinition = new BeanDefinition();
                            beanDefinition.setClazz(clazz);
                            if (clazz.isAnnotationPresent(Scope.class)) {
                                Scope scopeAnnotation = clazz.getDeclaredAnnotation(Scope.class);
                                beanDefinition.setScope(scopeAnnotation.value());
                            } else {
                                beanDefinition.setScope("singleton");
                            }
                            // 存入容器
                            beanDefinitionMap.put(beanName, beanDefinition);

                        }
                    } catch (ClassNotFoundException | NoSuchMethodException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }


}
