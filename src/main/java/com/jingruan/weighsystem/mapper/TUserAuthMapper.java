package com.jingruan.weighsystem.mapper;

import com.jingruan.weighsystem.entity.TUserAuth;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sfweight
 * @since 2021-02-02
 */
public interface TUserAuthMapper extends BaseMapper<TUserAuth> {

    List<TUserAuth> listByUID(int id);

    void add(Map map);

    void delByUID(int id);
}
