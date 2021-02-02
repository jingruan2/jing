package com.jingruan.weighsystem.service;

import com.jingruan.weighsystem.entity.TAuth;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author sfweight
 * @since 2021-02-02
 */
public interface TAuthService extends IService<TAuth> {

    List<TAuth> listByNo(int i);

}
