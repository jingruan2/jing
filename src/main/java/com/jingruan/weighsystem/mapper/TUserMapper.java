package com.jingruan.weighsystem.mapper;

import com.jingruan.weighsystem.entity.TUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sfweight
 * @since 2021-01-04
 */
public interface TUserMapper extends BaseMapper<TUser> {

    boolean updatepass(TUser tUser);
}
