package com.uxunchina.changsha.service.impl;

import com.uxunchina.changsha.pojo.dto.User;
import com.uxunchina.changsha.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by leo on 2017/7/4.
 */
@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<String> findPermissionUrl(String subjectId) {
        List<String> list=new ArrayList<String>();
        list.add("/test");
        return list;
    }

    @Override
    public User findUserInfo(String remoteToken) {

        //远程获取用户信息
      User user=  new User();
      user.setUserId("admin");
      user.setUserToken(remoteToken);

        return user;
    }

    @Override
    public Set<String> findPermissions(String subjectId) {
        return null;
    }
}
