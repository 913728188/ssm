package com.lmf.Mapper;

import com.lmf.base.BaseMapper;
import com.lmf.entity.User;
import org.apache.ibatis.annotations.Insert;


import java.util.List;

/**
 * com.lmf.Mapper
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/

@org.apache.ibatis.annotations.Mapper
public interface UserMapper extends BaseMapper<User> {
    @Insert(" INSERT INTO `t_user`(`id`,`name`,`password`) VALUES (#{id},#{name},#{password})")
    int insert(User u);

    List<User> findAll();
}
