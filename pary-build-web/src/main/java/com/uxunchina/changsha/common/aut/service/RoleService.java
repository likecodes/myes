package com.uxunchina.changsha.common.aut.service;

import com.uxunchina.changsha.common.aut.pojo.po.RolePo;

import java.util.List;

/**
 * Created by leo on 2017/7/10.
 */
public interface RoleService {
   /**
    * 获取资源的对应的多个角色
    */
    List<RolePo> obtainRolesByResource(String resources);
}
