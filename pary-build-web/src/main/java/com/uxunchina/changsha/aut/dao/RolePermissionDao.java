package com.uxunchina.changsha.aut.dao;

import com.uxunchina.changsha.aut.pojo.po.TAutRolePermission;

public interface RolePermissionDao {
    int insert(TAutRolePermission record);

    int insertSelective(TAutRolePermission record);
}