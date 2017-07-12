package com.uxunchina.changsha.common.aut.service;

import com.uxunchina.changsha.common.aut.pojo.po.PermissionPo;

import java.util.List;

/**
 * Created by leo on 2017/7/12.
 */
public interface UserMenuService {

    List<PermissionPo> genUserMenuData(String userName);
}
