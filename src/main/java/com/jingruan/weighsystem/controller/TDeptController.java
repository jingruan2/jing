package com.jingruan.weighsystem.controller;


import com.jingruan.weighsystem.common.lang.Result;
import com.jingruan.weighsystem.entity.TDept;
import com.jingruan.weighsystem.service.TDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author sfweight
 * @since 2021-01-04
 */
@RestController
@RequestMapping("/dept")
public class TDeptController {

    @Autowired
    TDeptService tDeptService;

    @RequestMapping("/list")
    public Result list(){


        List<TDept> list = tDeptService.list();


        return Result.success(list);

    }
}
