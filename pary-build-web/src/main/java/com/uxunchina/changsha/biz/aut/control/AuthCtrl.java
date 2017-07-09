package com.uxunchina.changsha.biz.aut.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by leo on 2017/7/3.
 */
@Controller
public class AuthCtrl {

    @RequestMapping("/")
    public String getRolesInfo(){
        return "index";
    }

    @RequestMapping("/xxxx")
    @ResponseBody
    public String getRoles(){
        return "loginxxxxx";
    }

    @RequestMapping("/test")
    public String test(){
       return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
