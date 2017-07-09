package com.uxunchina.changsha.common.aut.service;

import com.uxunchina.changsha.common.aut.dao.OperatorDao;
import com.uxunchina.changsha.common.aut.dao.PermissionDao;
import com.uxunchina.changsha.common.aut.dao.RolePermissionDao;
import com.uxunchina.changsha.common.aut.pojo.dto.UserDetailsDto;
import com.uxunchina.changsha.common.aut.pojo.po.OperatorPo;
import com.uxunchina.changsha.common.aut.pojo.po.PermissionPo;
import com.uxunchina.changsha.common.aut.pojo.po.RolePermissionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * spring security 实现类
 * Created by leo on 2017/7/4.
 */
@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private PermissionDao permissionDao;

    @Autowired
    private OperatorDao operatorDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        OperatorPo operator=this.operatorDao.selectByUserName(username);
        if (operator != null) {
            List<PermissionPo> permissions=this.permissionDao
                    .selectPermissionByUserId(operator.getOperatorId());
            List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
            for (PermissionPo permission : permissions) {
                if (permission != null && permission.getPermName()!=null) {

                    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getPermName());
                    grantedAuthorities.add(grantedAuthority);
                }
            }
            return new UserDetailsDto(operator.getUsername(), operator.getUserPassword(), grantedAuthorities);
        } else {
            throw new UsernameNotFoundException("账号: " + username + " 不存在!");
        }
    }
}
