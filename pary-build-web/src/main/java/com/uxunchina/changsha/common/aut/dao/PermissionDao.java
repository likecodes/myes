package com.uxunchina.changsha.common.aut.dao;

import com.uxunchina.changsha.common.aut.pojo.po.PermissionPo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    int deleteByPrimaryKey(String permId);

    int insert(PermissionPo record);

    int insertSelective(PermissionPo record);

    PermissionPo selectByPrimaryKey(String permId);

    int updateByPrimaryKeySelective(PermissionPo record);

    int updateByPrimaryKey(PermissionPo record);

    List<PermissionPo> selectAllPermissionPo();

    List<PermissionPo> selectPermissionByUserId(String userId);



}