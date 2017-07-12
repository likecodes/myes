package com.uxunchina.changsha.common.aut.service.impl;

import com.uxunchina.changsha.common.aut.dao.PermissionDao;
import com.uxunchina.changsha.common.aut.pojo.po.PermissionPo;
import com.uxunchina.changsha.common.aut.service.UserMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by leo on 2017/7/12.
 */
@Service
public class UserMenuServiceimpl implements UserMenuService {
    @Autowired
    private PermissionDao permissionDao;

    @Override
    public List<PermissionPo> genUserMenuData(String userName) {
        List<PermissionPo> permissions= this.permissionDao
                .selectPermissionByUserName(userName);
        return permissions;
    }

}
