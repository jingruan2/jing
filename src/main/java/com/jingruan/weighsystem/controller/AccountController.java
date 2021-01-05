package com.jingruan.weighsystem.controller;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jingruan.weighsystem.common.dto.LoginDto;
import com.jingruan.weighsystem.common.lang.Result;
import com.jingruan.weighsystem.entity.TUser;
import com.jingruan.weighsystem.service.TUserService;
import com.jingruan.weighsystem.util.JwtUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.util.Date;

@RestController
public class AccountController {
    @Autowired
    TUserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("login")
    public Result login(@Validated @RequestBody LoginDto loginDto){
        TUser user = userService.getOne(new QueryWrapper<TUser>().eq("username",loginDto.getUsername()));
        Assert.notNull(user,"用户名密码错误");
        if(!user.getPass().equals(SecureUtil.md5(loginDto.getPass()))){
            return Result.fail(300,"用户名密码错误",null);
        }
        if(!user.getDepart().equals(loginDto.getDepart())){
            return Result.fail("部门错误");
        }

        //获取长短token
        String accessToken = jwtUtils.getshort(user.getId());
        String refreshToken = jwtUtils.getlong(user.getId());

        TUser user1=new TUser();

        user1.setUsername(user.getUsername());
        user1.setDepart(user.getDepart());
        user1.setTime(user.getTime());
        user1.setTrueName(user.getTrueName());
        user1.setId(user.getId());


        return Result.success(MapUtil.builder()
                .put("userInfo",user1)
                .put("accessToken",accessToken)
                .put("refreshToken",refreshToken)
                .map()
        );
    }

    @RequiresAuthentication
    @GetMapping("/logout")
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return Result.success(null);
    }
}
