package com.jingruan.weighsystem.mapper;

import com.jingruan.weighsystem.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sfweight
 * @since 2021-01-04
 */
public interface TUserMapper extends BaseMapper<TUser> {

    //更新密码
    boolean updatepass(TUser tUser);

    //查询旧密码
    TUser getByUsername(String username);

    List<TUser>  onlyName(String username);

    List<TUser> queryByPtype(Map<String, Object> map);

    boolean del(int ids);

    boolean updateByuserId(TUser tUser);
}
