package com.uxunchina.changsha.common.aut.dao;

import com.uxunchina.changsha.common.aut.pojo.po.RolePermissionPo;

import java.util.List;

public interface RolePermissionDao {
    int insert(RolePermissionPo record);

    int insertSelective(RolePermissionPo record);

    List<RolePermissionPo> selectByRoleId(String roleId);

}