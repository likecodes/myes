package com.uxunchina.changsha.aut.service;

import com.uxunchina.changsha.aut.pojo.dto.User;

import java.util.List;
import java.util.Set;

/**
 * Created by leo on 2017/7/4.
 */
public interface UserService {

    List<String> findPermissionUrl(String subjectId);

    User findUserInfo(String userId);

    Set<String> findPermissions(String subjectId);


}