package com.jingruan.weighsystem.controller;

import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jingruan.weighsystem.common.dto.LoginDto;
import com.jingruan.weighsystem.common.lang.Result;
import com.jingruan.weighsystem.entity.TUser;
import com.jingruan.weighsystem.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class loginController {

    @Autowired
    TUserService userService;


    @ResponseBody
    @RequestMapping("/login")
    public Result login(@RequestBody LoginDto loginDto){

        TUser user = userService.getOne(new QueryWrapper<TUser>().eq("username",loginDto.getUsername()));

        if(!user.getPass().equals(SecureUtil.md5(loginDto.getPass()))){
            return Result.fail(300,"用户名密码错误",null);
        }
        if(!user.getDepart().equals(loginDto.getDepart())){
            return Result.fail("部门错误");
        }
        TUser user1=new TUser();

        user1.setUsername(user.getUsername());
        user1.setDepart(user.getDepart());
        user1.setTime(user.getTime());
        user1.setTrueName(user.getTrueName());
        user1.setId(user.getId());


        return Result.success(MapUtil.builder()
                .put("userInfo",user1)
                .map()
        );
    }
}
