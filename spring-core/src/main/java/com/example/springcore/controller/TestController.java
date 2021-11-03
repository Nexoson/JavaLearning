package com.example.springcore.controller;

import com.example.springcore.service.TestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author huangX huangxun@lidomtech.com
 * @version 1.0
 * @className TestController
 * @date 2021/11/2 15:11
 * @desc 测试视图层
 **/

@RestController
@RequestMapping("test")
@Api(tags = "测试视图层")
@Slf4j
public class TestController {

    @Resource
    TestService testService;


    @GetMapping("info")
    @ApiOperation("测试信息")
    public String getInfo(@RequestParam String id) throws InterruptedException {
        return testService.getInfo(id);
    }

}
