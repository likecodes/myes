package com.uxunchina.changsha.aut.dao;

import com.uxunchina.changsha.aut.pojo.po.TAutPermission;

public interface PermissionDao {
    int deleteByPrimaryKey(String permId);

    int insert(TAutPermission record);

    int insertSelective(TAutPermission record);

    TAutPermission selectByPrimaryKey(String permId);

    int updateByPrimaryKeySelective(TAutPermission record);

    int updateByPrimaryKey(TAutPermission record);
}