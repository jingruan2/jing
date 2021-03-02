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

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

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

        int id = tUser.getId();

        List<TUserAuth> userAuthList = tUserAuthService.listByUID(id);

        List<TAuth> list1 = tAuthService.listByNo(1);
        List<TAuth> list2 = tAuthService.listByNo(2);
        List<TAuth> list3 = tAuthService.listByNo(3);
        List<TAuth> list4 = tAuthService.listByNo(4);

        List<Integer> list5 = new LinkedList();
        for (TUserAuth userAuth : userAuthList) {
            list5.add(userAuth.getAid());
        }

        return Result.success(MapUtil.builder()
                .put("list1", list1)
                .put("list2", list2)
                .put("list3", list3)
                .put("list4", list4)
                .put("list5", list5)
                .map());
    }


    @RequestMapping("/save")
    public Result save(@RequestBody AuthVO authVO) {

        tUserAuthService.delByUID(authVO.getId());


        if (authVO.getIds().length()!=0){
            String ids=authVO.getIds();
            ids=ids.substring(1,ids.length()-1);
            String[] split = ids.split(",");


            for (String s : split) {

                Map map=new HashMap();
                map.put("uid",authVO.getId());
                map.put("aid",Integer.parseInt(s));
                int i = Integer.parseInt(s);
                tUserAuthService.add(map);
            }
        }


        return Result.success(200,"保存成功",null);
    }
}
