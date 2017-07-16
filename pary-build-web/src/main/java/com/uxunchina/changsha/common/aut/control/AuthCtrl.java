package com.uxunchina.changsha.common.aut.control;

import com.uxunchina.changsha.common.aut.pojo.dto.HttpJsonResponse;
import org.springframework.http.HttpRequest;
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

    @RequestMapping("/index")
    public String index(){
        return "index.html";
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

    @RequestMapping("/loginPage")
    public String login(){
        return "/html/login.html";
    }



    @RequestMapping("/login/success")
    public @ResponseBody HttpJsonResponse success() {
        return new HttpJsonResponse("0", "登录成功");
    }



    @RequestMapping("/login/failure")
    public @ResponseBody HttpJsonResponse failure() {
        return new HttpJsonResponse("1", "用户名或密码不正确");
    }

    @RequestMapping("/403")
    public String accessDenied(){
        return "403";
    }
}
