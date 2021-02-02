package com.jingruan.weighsystem.controller;


import cn.hutool.core.map.MapUtil;
import com.jingruan.weighsystem.common.lang.Result;
import com.jingruan.weighsystem.entity.TRole;
import com.jingruan.weighsystem.service.TRoleService;
import com.jingruan.weighsystem.service.TUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/role")
public class TRoleController {

    @Autowired
    TRoleService tRoleService;

    @RequestMapping("/list")
    public Result del(){

        List<TRole> list1=tRoleService.listByNo(1);
        List<TRole> list2=tRoleService.listByNo(2);
        List<TRole> list3=tRoleService.listByNo(3);
        List<TRole> list4=tRoleService.listByNo(4);

        return Result.success(MapUtil.builder()
                .put("list1",list1)
                .put("list2",list2)
                .put("list3",list3)
                .put("list4",list4)
                .map()
        );
    }
}
