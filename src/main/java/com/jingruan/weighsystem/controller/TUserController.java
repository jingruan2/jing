package com.jingruan.weighsystem.controller;


import cn.hutool.core.map.MapUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSON;
import com.jingruan.weighsystem.common.lang.Result;
import com.jingruan.weighsystem.entity.DelVO;
import com.jingruan.weighsystem.entity.TUser;
import com.jingruan.weighsystem.entity.UserVO;
import com.jingruan.weighsystem.service.TUserService;
import com.jingruan.weighsystem.util.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public Result addUser(@RequestBody TUser tUser){

        List<TUser> list=tUserService.onlyName(tUser.getUsername());

        if (list.size()==0){
            Date date=new Date();
            tUser.setTime(date);
            tUser.setPass(SecureUtil.md5(tUser.getPass()));
            boolean save = tUserService.save(tUser);

            if (save){

                return Result.success(200,"添加成功",null);

            }else {

                return Result.fail(300,"添加失败",null);
            }
        }

        return Result.fail(300,"添加失败,用户已存在",null);

    }

    @RequestMapping("/updatepass")
    public Result saveUser(@RequestBody UserVO user){
        //获取旧密码
        String oldPass=tUserService.getByUsername(user.getUsername()).getPass();

        //System.out.println(oldPass+"   "+oldPass);
        //判断密码是否一致
        if (oldPass.equals(SecureUtil.md5(user.getOldpass()))){

            //获取新密码
            String newPass=SecureUtil.md5(user.getPass());

            TUser tUser=new TUser();
            tUser.setUsername(user.getUsername());
            tUser.setPass(newPass);

            //修改密码
            tUserService.updatepass(tUser);

            return Result.fail(200,"密码修改成功",null);
        }


        return Result.fail(300,"当前密码错误",null);
    }



    @RequestMapping("/list")
    public Result userList(@RequestBody PageHelper pageHelper){

        //设置分页
        Integer count = tUserService.count();
        pageHelper.setTotalCount(count);

        //分页
        Map<String,Object> map=new HashMap<>();
        map.put("pageCount",pageHelper.getPageCount());
        map.put("pageNo",(pageHelper.getPageNo()-1)*pageHelper.getPageCount());

        List<TUser> list=tUserService.queryByPtype(map);

        return Result.success(MapUtil.builder()
        .put("list",list)
        .put("pageHelper",pageHelper)
        .map());
    }

    @RequestMapping("/del")
    public Result del(@RequestBody DelVO delVO){

        String ids=delVO.getSelectedRowKeys();
        ids=ids.substring(1,ids.length()-1);
        String[] split = ids.split(",");

        for (String s : split) {
            int i = Integer.parseInt(s);
            tUserService.del(i);
        }

        return Result.success(200,"删除成功",null);
    }

    /*@RequestMapping("/list1")
    public Result userList1(PageHelper pageHelper) {
        //设置分页
        Integer count = tUserService.count();
        pageHelper.setTotalCount(count);

        //分页
        Map<String,Object> map=new HashMap<>();
        map.put("pageCount",pageHelper.getPageCount());
        map.put("pageNo",pageHelper.getPageNo());

        List<TUser> list=tUserService.queryByPtype(map);

        return Result.success(MapUtil.builder()
                .put("list",list)
                .put("pageHelper",pageHelper)
                .map());
    }*/

    @RequestMapping("/updateuser")
    public Result update(@RequestBody TUser tUser) {

        tUser.setPass(SecureUtil.md5(tUser.getPass()));
        boolean isupdate = tUserService.updateByuserId(tUser);
        if (isupdate) {
            return Result.success(200, "修改成功", null);
        }
        return Result.success(300, "修改失败", null);

    }

}
