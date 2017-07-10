package com.uxunchina.changsha.common.aut.service.impl;

import com.uxunchina.changsha.common.aut.dao.PermissionDao;
import com.uxunchina.changsha.common.aut.dao.RolePermissionDao;
import com.uxunchina.changsha.common.aut.pojo.po.PermissionPo;
import com.uxunchina.changsha.common.aut.pojo.po.RolePo;
import com.uxunchina.changsha.common.aut.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by leo on 2017/7/10.
 */
public class RoleServiceImpl implements RoleService {
    @Autowired
    private PermissionDao permissionDao;
    @Autowired
    private RolePermissionDao rolePermissionDao;


    @Override
    public List<RolePo> obtainRolesByResource(String resources) {
        
        return null;
    }
}
