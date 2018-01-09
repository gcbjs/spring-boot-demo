package com.yzb.springboot.controller;

import com.yzb.springboot.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Create by yuzhangbin on 2018/1/8
 */
@Controller
public class HelloWorldController {


    @RequestMapping("/hello")
    public String sayHello() throws Exception {
        throw new MyException("发生错误wwwww");
    }

    @RequestMapping("/")
    public String index(Model map) {
        map.addAttribute("host", "http://blog.didispace.com");
        return "index";
    }
}
