package com.uxunchina.changsha.aut.dao;

import com.uxunchina.changsha.aut.pojo.po.TAutUserRole;

public interface UserRoleDao {
    int insert(TAutUserRole record);

    int insertSelective(TAutUserRole record);
}