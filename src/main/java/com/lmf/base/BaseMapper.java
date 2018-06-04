package com.lmf.base;

import com.lmf.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * com.lmf.base
 * <p>
 * root创建于18-6-1
 * TODO:进行描述
 **/
public interface BaseMapper<T>  extends MySqlMapper<T>,Mapper<T>,tk.mybatis.mapper.common.BaseMapper<T> {


    @Select("select * from t_user where email = #{email} and password = #{password}")
    User findByEmailAndPwd(@Param("email") String email, @Param("password") String password);
}
