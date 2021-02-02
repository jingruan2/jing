package com.jingruan.weighsystem.service;

import com.jingruan.weighsystem.entity.TUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.jingruan.weighsystem.entity.UserVO;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sfweight
 * @since 2021-01-04
 */
public interface TUserService extends IService<TUser> {

    //更新密码
    void updatepass(TUser tUser);

    //查询旧密码
    TUser getByUsername(String username);

    //用户名是否唯一
    List<TUser>  onlyName(String username);

    List<TUser> queryByPtype(Map<String, Object> map);

    boolean del(int ids);

    boolean updateByuserId(TUser tUser);
}
