package com.uxunchina.changsha.common.aut.control;

import com.uxunchina.changsha.common.aut.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by leo on 2017/7/12.
 */
@Controller
@RequestMapping("/aut/mng")
public class AuthManagementsCtrl {

    @Autowired
    private UserMenuService userPersionService;

    @RequestMapping("/user/menu")
    @ResponseBody
    public String getUserMenu(){
        UserDetails userDetails = (UserDetails)SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();

        userDetails.getUsername();
        return "loginxxxxx";
    }
}
