package com.uxunchina.changsha.common.aut.dao;

import com.uxunchina.changsha.common.aut.pojo.po.RolePo;

import java.util.List;

public interface RoleDao {
    int deleteByPrimaryKey(String roleId);

    int insert(RolePo record);

    int insertSelective(RolePo record);

    RolePo selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(RolePo record);

    int updateByPrimaryKey(RolePo record);

    List<RolePo>  selectRolesByResource(String permissionId);

    List<RolePo>  selectRolesByOperatorId(String operatorId);
}