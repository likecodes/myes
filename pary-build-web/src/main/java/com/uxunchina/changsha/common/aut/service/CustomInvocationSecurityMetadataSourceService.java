package com.uxunchina.changsha.common.aut.service;

import com.uxunchina.changsha.common.aut.dao.PermissionDao;
import com.uxunchina.changsha.common.aut.pojo.po.PermissionPo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by leo on 2017/7/8.
 */
@Service
public class CustomInvocationSecurityMetadataSourceService implements
        FilterInvocationSecurityMetadataSource {
    private Logger log= LoggerFactory.getLogger(getClass());
    @Autowired
    PermissionDao permissionDao;
    /**
     * 资源权限
     */
    private Map<String, Collection<ConfigAttribute>> configAttributeCache =new ConcurrentHashMap<>();
    /**
     * 加载资源与权限的定义
     */
    @PostConstruct
    private void loadResourceDefine(){
        log.info("控制权限开始加载...");
        Collection<ConfigAttribute> array;
        ConfigAttribute cfg;
        List<PermissionPo> permissions = permissionDao.selectAllPermissionPo();
        for(PermissionPo permission : permissions) {
            array = new ArrayList<>();
            cfg = new SecurityConfig(permission.getPermName());
            array.add(cfg);
            configAttributeCache.put(permission.getResouce(), array);
            if(log.isDebugEnabled()){
                log.debug("权限名为{}对应的URL为{}",
                        permission.getPermName(),permission.getResouce());
            }
        }
        log.info("控制权限数据加载结束");

    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //object 中包含用户请求的request 信息
        HttpServletRequest request = ((FilterInvocation) object).getHttpRequest();
        AntPathRequestMatcher matcher;
        String resUrl;
        for(Iterator<String> iter = configAttributeCache.keySet().iterator(); iter.hasNext(); ) {
            resUrl = iter.next();
            matcher = new AntPathRequestMatcher(resUrl);
            if(matcher.matches(request)) {
                return configAttributeCache.get(resUrl);
            }
        }
        matcher = new AntPathRequestMatcher("/login");
        if(matcher.matches(request)){
           return null;
        }
        Collection<ConfigAttribute> nouse = new ArrayList<ConfigAttribute>();
        nouse.add(new SecurityConfig("NOT_ANY_PERMISSION"));
        return nouse;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
}
