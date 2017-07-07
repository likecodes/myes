package com.uxunchina.changsha.aut.dao;

import com.uxunchina.changsha.aut.pojo.po.TAutOperator;

public interface OperatorDao {
    int deleteByPrimaryKey(String operatorId);

    int insert(TAutOperator record);

    int insertSelective(TAutOperator record);

    TAutOperator selectByPrimaryKey(String operatorId);

    int updateByPrimaryKeySelective(TAutOperator record);

    int updateByPrimaryKey(TAutOperator record);
}