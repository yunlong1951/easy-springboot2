package com.example.boot.common.config;

import com.example.boot.common.utils.ShiroUtils;
import com.example.boot.model.role.Permissions;
import com.example.boot.model.role.Role;
import com.example.boot.model.user.User;
import com.example.boot.service.User.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户名
        String name = (String) principalCollection.getPrimaryPrincipal();
        //根据用户名去数据库查询用户信息
        User user = userService.login(name);
        //添加角色和权限
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        for (Role role : user.getRoles()) {
            //添加角色
            simpleAuthorizationInfo.addRole(role.getRoleCode());
            //添加权限
            for (Permissions permissions : role.getPermissions()) {
                simpleAuthorizationInfo.addStringPermission(permissions.getPermissionsCode());
            }
        }
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //加这一步的目的是在Post请求的时候会先进认证，然后在到请求

        if (authenticationToken.getPrincipal() == null) {
            return null;
        }
        //获取用户信息
//        String name = authenticationToken.getPrincipal().toString();
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        StringBuilder password = new StringBuilder(100);
        for (int i=0;i<token.getPassword().length;i++){
            password.append(token.getPassword()[i]);
        }
        User user = userService.login(token.getUsername());
        if (user == null) {
            //这里返回后会报出对应异常
            return null;
        } else {
            //这里验证authenticationToken和simpleAuthenticationInfo的信息
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user.getUserName(), password.toString(), token.getUsername());
            return simpleAuthenticationInfo;
        }
    }
    /**
     * 将自己的验证方式加入容器
     *
     * 凭证匹配器（由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了）
     *
     * @param credentialsMatcher
     */
//    @Override
//    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
//        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
//
//        /**
//         * 散列算法:这里可以使用MD5算法 也可以使用SHA-256
//         */
//        hashedCredentialsMatcher.setHashAlgorithmName(ShiroUtils.hashAlgorithmName);
//        // 散列的次数，比如散列16次，相当于 md5(md5(""));
//        hashedCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
//        super.setCredentialsMatcher(hashedCredentialsMatcher);
//    }
}
