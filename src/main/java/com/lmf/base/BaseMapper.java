package com.lmf.base;

import com.lmf.entity.User;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * com.lmf.base
 * <p>
 * root创建于18-6-1
 * TODO:进行描述
 **/
public interface BaseMapper<T>  extends MySqlMapper<T>,Mapper<T>,tk.mybatis.mapper.common.BaseMapper<T> {
}
