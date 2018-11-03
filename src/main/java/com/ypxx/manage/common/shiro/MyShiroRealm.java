package com.ypxx.manage.common.shiro;

import com.ypxx.manage.common.utils.PasswordUtils;
import com.ypxx.manage.system.login.service.ILoginService;
import com.ypxx.manage.system.permission.entity.PermissionEntity;
import com.ypxx.manage.system.role.entity.RoleEntity;
import com.ypxx.manage.system.user.entity.UserEntity;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

/**
 * Created by xuwei on 2018/10/5.
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private ILoginService loginService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        UserEntity userInfo  = (UserEntity) principals.getPrimaryPrincipal();
        RoleEntity role = userInfo.getRole();
        authorizationInfo.addRole(role.getRole());
        for(PermissionEntity p:role.getPermissions()){
            authorizationInfo.addStringPermission(p.getPermission());
        }
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username = (String)token.getPrincipal();
        UserEntity user = loginService.findByUsername(username);
        if (user == null) return null;
        byte[] salt = PasswordUtils.decodeHex(user.getPassword().substring(0, 16));
        return new SimpleAuthenticationInfo(
                user,
                user.getPassword().substring(16),
                ByteSource.Util.bytes(salt),
                getName()
        );
    }

    @PostConstruct
    public void initCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher("SHA-1");
        matcher.setHashIterations(1024);
        setCredentialsMatcher(matcher);
    }
}
