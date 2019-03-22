package com.mmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @description:
 * @author:zh
 * @date:2019/1/17
 */
@Controller
@RequestMapping("/test/")
public class TestController {

    @RequestMapping("test.do")
    @ResponseBody
    public String test(String str){

        System.out.println("已联通");
        return "testValue"+str;
    }

}
