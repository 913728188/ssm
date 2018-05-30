package com.lmf.Mapper;

import com.lmf.entity.User;
import org.apache.ibatis.annotations.Insert;

/**
 * com.lmf.Mapper
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/

public interface UserMapper {

    int insert(User u);
}
