package com.jingruan.weighsystem.service.impl;

import com.jingruan.weighsystem.entity.TUserAuth;
import com.jingruan.weighsystem.mapper.TUserAuthMapper;
import com.jingruan.weighsystem.service.TUserAuthService;
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
 * @since 2021-02-02
 */
@Service
public class TUserAuthServiceImpl extends ServiceImpl<TUserAuthMapper, TUserAuth> implements TUserAuthService {

    @Autowired
    TUserAuthMapper tUserAuthMapper;

    @Override
    public List<TUserAuth> listByUID(int id) {
        return tUserAuthMapper.listByUID(id);
    }

    @Override
    public void add(Map map) {
        tUserAuthMapper.add(map);
    }

    @Override
    public void delByUID(int id) {
        tUserAuthMapper.delByUID(id);
    }
}
