package com.jingruan.weighsystem.mapper;

import com.jingruan.weighsystem.entity.TRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sfweight
 * @since 2021-02-02
 */
public interface TRoleMapper extends BaseMapper<TRole> {

    List<TRole> listByNo(int i);
}
