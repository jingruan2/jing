package com.jingruan.weighsystem.service.impl;

import com.jingruan.weighsystem.entity.TRole;
import com.jingruan.weighsystem.mapper.TRoleMapper;
import com.jingruan.weighsystem.service.TRoleService;
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
public class TRoleServiceImpl extends ServiceImpl<TRoleMapper, TRole> implements TRoleService {

    @Autowired
    TRoleMapper tRoleMapper;

    @Override
    public List<TRole> listByNo(int i) {
        return tRoleMapper.listByNo(i);
    }
}
