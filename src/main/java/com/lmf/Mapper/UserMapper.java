package com.lmf.Mapper;

import com.lmf.base.BaseMapper;
import com.lmf.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;


import java.util.List;

/**
 * com.lmf.Mapper
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends BaseMapper<User> {
    @Insert(" INSERT INTO `user`(`id`,`name`,`password`,`email`) VALUES (#{id},#{name},#{password},#{email})")
    int insert(User u);

    List<User> findAll();

    @Select("select * from user where email = #{email} and password = #{password}")
    User findByEmailAndPwd(@Param("email") String email, @Param("password") String password);
}
