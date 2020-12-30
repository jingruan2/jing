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

@RestController
public class AccountController {
    @Autowired
    TUserService userService;

    @Autowired
    JwtUtils jwtUtils;

    @PostMapping("login")
    public Result login(@Validated @RequestBody LoginDto loginDto, HttpServletResponse response){
        TUser user = userService.getOne(new QueryWrapper<TUser>().eq("F_Name",loginDto.getUsername()));
        Assert.notNull(user,"用户不存在");
        if(!user.getFPass().equals(SecureUtil.md5(loginDto.getPassword())) ){
            return Result.fail("密码不正确");
        }
        String jwt = jwtUtils.generateToken(user.getFId());
        response.setHeader("Authorizaion",jwt);
        response.setHeader("Access-control-Expost-Headers","Authorizaion");

        return Result.success(MapUtil.builder()
                .put("id",user.getFId())
                .put("username",user.getFName())
                .put("truename",user.getFTruename())
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
