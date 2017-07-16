package com.uxunchina.changsha.common.aut.control;

import com.uxunchina.changsha.Constant;
import com.uxunchina.changsha.common.aut.pojo.po.PermissionPo;
import com.uxunchina.changsha.common.aut.service.UserMenuService;
import com.uxunchina.changsha.common.base.vo.ResponseVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by leo on 2017/7/12.
 */
@Controller
@RequestMapping("/aut/mng")
public class AuthManagementsCtrl {

    @Autowired
    private UserMenuService userMenuService;

    @RequestMapping("/user/permsions")
    public @ResponseBody
            ResponseVo< List<PermissionPo>> getUserPermsions(){
        ResponseVo< List<PermissionPo>> responseVo=new  ResponseVo< List<PermissionPo>>();
        responseVo.setRetcode(Constant.SUCCESS_RETURN_CODE);
        UserDetails userDetails = (UserDetails)SecurityContextHolder
                .getContext().getAuthentication().getPrincipal();
        List<PermissionPo> permissions= this.userMenuService
                .genUserMenuData(userDetails.getUsername());
        responseVo.setData(permissions);
        return  responseVo;
    }

    @RequestMapping("/oparator")
    public String  getOparatorPages(){

        return  "aut-operator";
    }
}
