package com.lmf.Mapper;

import com.lmf.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * com.lmf.Mapper
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/

@Mapper
public interface UserMapper {
    @Insert(" INSERT INTO `t_user`(`id`,`name`,`password`) VALUES (#{id},#{name},#{password})")
    int insert(User u);
}
