package com.jingruan.weighsystem.controller;


import cn.hutool.core.map.MapUtil;
import com.jingruan.weighsystem.common.lang.Result;
import com.jingruan.weighsystem.entity.AuthVO;
import com.jingruan.weighsystem.entity.TAuth;
import com.jingruan.weighsystem.entity.TUser;
import com.jingruan.weighsystem.entity.TUserAuth;
import com.jingruan.weighsystem.service.TAuthService;
import com.jingruan.weighsystem.service.TUserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sfweight
 * @since 2021-02-02
 */
@RestController
@RequestMapping("auth")
public class TAuthController {

    @Autowired
    TAuthService tAuthService;

    @Autowired
    TUserAuthService tUserAuthService;

    @RequestMapping("/list")
    public Result update(@RequestBody TUser tUser) {

        int id=tUser.getId();

        List<TUserAuth> userAuthList=tUserAuthService.listByUID(id);

        List<TAuth> authslist=tAuthService.list();

        List<Integer> authIDs=new LinkedList();
        for (TUserAuth userAuth : userAuthList) {
            authIDs.add(userAuth.getAid());
        }


        return Result.success(MapUtil.builder()
                .put("authslist",authslist)
                .put("authIDs",authIDs)
                .map());
    }
}
