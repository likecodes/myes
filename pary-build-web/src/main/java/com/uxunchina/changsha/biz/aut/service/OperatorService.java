package com.uxunchina.changsha.biz.aut.service;

import com.uxunchina.changsha.biz.aut.pojo.dto.User;

import java.util.List;
import java.util.Set;

/**
 * Created by leo on 2017/7/4.
 */
public interface OperatorService {

    List<String> findPermissionUrl(String subjectId);

    User findUserInfo(String userId);

    Set<String> findPermissions(String subjectId);


}
