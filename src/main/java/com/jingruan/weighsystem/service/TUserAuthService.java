package com.jingruan.weighsystem.service;

import com.jingruan.weighsystem.entity.TUserAuth;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sfweight
 * @since 2021-02-02
 */
public interface TUserAuthService extends IService<TUserAuth> {

    List<TUserAuth> listByUID(int id);

    void add(Map map);

    void delByUID(int id);
}
