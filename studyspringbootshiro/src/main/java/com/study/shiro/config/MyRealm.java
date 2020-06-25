package com.study.shiro.config;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm {
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取用户名
        Object primaryPrincipal = (String)principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        //给用户设置权限，权限信息存在
        simpleAuthorizationInfo.setRoles(null);
        //给用户设置权限，
        simpleAuthorizationInfo.setObjectPermissions(null);
        simpleAuthorizationInfo.setObjectPermissions(null);
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //根据token获取用户名，
        String principal = (String)authenticationToken.getPrincipal();
        //根据用户名从数据库中查询该用户


        //

        return null;
    }
}
