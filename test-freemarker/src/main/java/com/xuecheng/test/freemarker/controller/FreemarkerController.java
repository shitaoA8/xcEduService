package com.xuecheng.test.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@RequestMapping("/freemarker")
@Controller
public class FreemarkerController {

    //测试1
    @RequestMapping("/test1")
    public String test(Map<String, Object> map) {
        System.out.println("+++++++++++++++++------");
        //map就是freemarker模板所使用的数据
        map.put("name","王二小");
        //返回freemarker模板的位置,基于resources/templates路径
        return "test1";
    }

}
