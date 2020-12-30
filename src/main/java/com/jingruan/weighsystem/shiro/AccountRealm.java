package com.jingruan.weighsystem.shiro;

import cn.hutool.core.bean.BeanUtil;

import com.jingruan.weighsystem.entity.TUser;
import com.jingruan.weighsystem.service.TUserService;
import com.jingruan.weighsystem.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.stereotype.Component;

@Component
public class AccountRealm extends AuthorizingRealm {
    @Autowired
    JwtUtils jwtUtils;
    @Autowired
    TUserService userService;
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
       JwtToken jwtToken = (JwtToken) token;
        String userid = jwtUtils.getClaimByToken((String)jwtToken.getPrincipal()).getSubject();
        TUser user =userService.getById(Integer.valueOf(userid));
        if(user == null){
            throw  new UnknownAccountException("账户不存在");
        }
//        if(user.getStatus()==-1)
//            throw new LockedAccountException("账户已被锁定");
        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user,profile);
        return new SimpleAuthenticationInfo(profile,jwtToken.getCredentials(),getName());
    }
}
