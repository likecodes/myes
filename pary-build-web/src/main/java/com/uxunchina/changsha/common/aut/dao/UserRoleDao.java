package com.uxunchina.changsha.common.aut.dao;

import com.uxunchina.changsha.common.aut.pojo.po.UserRolePo;

public interface UserRoleDao {
    int insert(UserRolePo record);

    int insertSelective(UserRolePo record);
}