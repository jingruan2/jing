package com.jingruan.weighsystem.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.crypto.digest.MD5;
import com.jingruan.weighsystem.common.dto.LoginDto;
import com.jingruan.weighsystem.common.lang.Result;
import com.jingruan.weighsystem.entity.TUser;
import com.jingruan.weighsystem.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sfweight
 * @since 2020-12-30
 */
@RestController
@RequestMapping("/user")
public class TUserController {

    @Autowired
    TUserService tUserService;

    @RequestMapping("/add")
    public Result addUser(@Validated @RequestBody TUser tUser){

        Date date=new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        tUser.setTime(sdf.format(date));
        tUser.setPass(SecureUtil.md5(tUser.getPass()));
        boolean save = tUserService.save(tUser);

        if (save){

            return Result.success(200,"添加成功",tUser);

        }else {

            return Result.fail(400,"添加失败",null);
        }
    }

    @RequestMapping("/update")
    public String saveUser(){
        return "保存成功";
    }
}
