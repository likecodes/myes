package com.uxunchina.changsha.aut.dao;

import com.uxunchina.changsha.aut.pojo.po.TAutRole;

public interface RoleDao {
    int deleteByPrimaryKey(String roleId);

    int insert(TAutRole record);

    int insertSelective(TAutRole record);

    TAutRole selectByPrimaryKey(String roleId);

    int updateByPrimaryKeySelective(TAutRole record);

    int updateByPrimaryKey(TAutRole record);
}