package com.tu.redisDemo.mvctest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.jws.HandlerChain;

@Controller
public class HelloTestController {

    @RequestMapping(value = "/doHello",method = RequestMethod.GET)
    public String doHello(){
        //@PathVariable("aa") Integer aa,
        System.out.println("调用方法");
        return "hello";
    }

    @ResponseBody
    //1、通过@RequestParam标签获取请求参数，并设置默认值
    @RequestMapping(value = "/doRequestParam", method = RequestMethod.PUT)
    public String testRequestParam(@RequestParam(value = "aa", required = false, defaultValue = "aa") String aa){

        return "ok";
    }

    //2、通过@PathVariable标签获取请求连接设置的参数
    @RequestMapping(value = "/doPathVariable/{aa}", method = RequestMethod.POST)
    public String testPathVariable(@PathVariable("aa") String aa){

        return "ok";
    }

    //3、通过@RequestHeader标签，获取请求头信息
    @RequestMapping(value = "/doRequestHeader", method = RequestMethod.PUT)
    public String testRequestHeader(@RequestHeader(value = "host") String host){

        System.out.println(host);
        return "ok";
    }

    //4、通过@CookieValue标签请求cookie信息
    @RequestMapping(value = "/doCookieValue", method = RequestMethod.PUT)
    public String testCookieValue(@CookieValue(value = "JESSId") String jessid){

        try{ int i=0;}catch (Exception e){}


        return "ok";
    }

//    Object

    //5、 POJO

    //6、Servlet
}
