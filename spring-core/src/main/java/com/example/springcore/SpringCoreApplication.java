package com.example.springcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 黄迅
 */
@SpringBootApplication(scanBasePackages = "com.example.springcore")
//@EnableAspectJAutoProxy(proxyTargetClass = true)
public class SpringCoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCoreApplication.class, args);
    }

}
