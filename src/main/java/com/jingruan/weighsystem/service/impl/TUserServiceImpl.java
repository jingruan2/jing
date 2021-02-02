package com.jingruan.weighsystem.service.impl;

import com.jingruan.weighsystem.entity.TUser;
import com.jingruan.weighsystem.mapper.TUserMapper;
import com.jingruan.weighsystem.service.TUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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


    @Override
    public TUser getByUsername(String username) {
        return tUserMapper.getByUsername(username);
    }

    @Override
    public List<TUser>  onlyName(String username) {
        return tUserMapper.onlyName(username);
    }

    @Override
    public List<TUser> queryByPtype(Map<String, Object> map) {
        return tUserMapper.queryByPtype(map);
    }

    @Override
    public boolean del(int ids) {
        return tUserMapper.del(ids);
    }

    @Override
    public boolean updateByuserId(TUser tUser) {
        return tUserMapper.updateByuserId(tUser);
    }
}
