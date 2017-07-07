package com.uxunchina.changsha.aut.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by leo on 2017/7/3.
 */
@Controller
public class AuthCtrl {

    @RequestMapping("/")
    public String getRolesInfo(){
        return "login";
    }

    @RequestMapping("/test")
    public String test(){
       return "test";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }
}
