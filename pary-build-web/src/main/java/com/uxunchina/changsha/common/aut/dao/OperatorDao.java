package com.uxunchina.changsha.common.aut.dao;

import com.uxunchina.changsha.common.aut.pojo.po.OperatorPo;

public interface OperatorDao {
    int deleteByPrimaryKey(String operatorId);

    int insert(OperatorPo record);

    int insertSelective(OperatorPo record);

    OperatorPo selectByPrimaryKey(String operatorId);

    OperatorPo selectByUserName(String userName);

    int updateByPrimaryKeySelective(OperatorPo record);

    int updateByPrimaryKey(OperatorPo record);
}