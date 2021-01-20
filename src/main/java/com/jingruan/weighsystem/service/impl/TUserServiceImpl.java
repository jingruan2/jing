package com.jingruan.weighsystem.service.impl;

import com.jingruan.weighsystem.entity.TUser;
import com.jingruan.weighsystem.mapper.TUserMapper;
import com.jingruan.weighsystem.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sfweight
 * @since 2021-01-04
 */
@Service
public class TUserServiceImpl extends ServiceImpl<TUserMapper, TUser> implements TUserService {

    @Autowired
    TUserMapper tUserMapper;

    @Override
    public void updatepass(TUser tUser) {
        tUserMapper.updatepass(tUser);
    }
}
