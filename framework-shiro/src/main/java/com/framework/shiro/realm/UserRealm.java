package com.framework.shiro.realm;

import com.framework.shiro.service.ShiroService;
import com.framework.shiro.vo.ShiroUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Autowired
    private ShiroService shiroService;

    public UserRealm() {}

    @Autowired
    public UserRealm(CredentialsMatcher credentialsMatcher) {
        super(credentialsMatcher);
    }
    /**
     * 获取用户权限
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("-- doGetAuthorizationInfo 获取用户权限");
        String loginId = (String)principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(shiroService.queryRoles(loginId));
        authorizationInfo.setStringPermissions(shiroService.queryPermissions(loginId));
        return authorizationInfo;
    }

    /**
     * 登录认证
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("-- doGetAuthenticationInfo 登录认证");
        String loginId = (String)authenticationToken.getPrincipal();
        log.info("longid : {}", loginId);
        ShiroUser user = shiroService.queryUserByLoginId(loginId);

        if(user == null) {
            log.info("longid : {} user is null ", loginId);
            throw new UnknownAccountException();
        }

        log.info("longid : {} user is {} ", loginId, user.isLock());

        //帐号锁定
        if(Boolean.TRUE.equals(user.isLock())) {
            log.info("longid : {} user is del ", loginId);
            throw new LockedAccountException();
        }

        log.info("user:{}",user.toString());

        SimpleAuthenticationInfo authenticationInfo  = new SimpleAuthenticationInfo(
                user.getLoginId(), //用户名
                user.getPassword(), //密码
                ByteSource.Util.bytes(user.getCredentials()),//salt=loginId+salt
                getName() //UserRealm
        );

        return authenticationInfo;
    }

}
