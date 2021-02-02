package com.jingruan.weighsystem.service.impl;

import com.jingruan.weighsystem.entity.TAuth;
import com.jingruan.weighsystem.mapper.TAuthMapper;
import com.jingruan.weighsystem.service.TAuthService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sfweight
 * @since 2021-02-02
 */
@Service
public class TAuthServiceImpl extends ServiceImpl<TAuthMapper, TAuth> implements TAuthService {

    @Autowired
    TAuthMapper tAuthMapper;

    @Override
    public List<TAuth> listByNo(int i) {
        return tAuthMapper.listByNo(i);
    }
}
