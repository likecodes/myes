package com.uxunchina.changsha.aut.control;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by leo on 2017/7/3.
 */
@Controller
public class AuthCtrl {

    @RequestMapping("/")
    @ResponseBody
    public String getRolesInfo(){
        return "hell world";
    }

    @RequestMapping("/login")
    public String login(){
       return "测试";
    }
}
