package com.lmf.service.impl;

import com.lmf.Mapper.UserMapper;
import com.lmf.base.BaseServiceImpl;
import com.lmf.entity.User;
import com.lmf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.lmf.service.impl
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/
@Service
public class UserServiceImpl  extends BaseServiceImpl<User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    public User addUser(User u){
       int count =   userMapper.insert(u);
       return u;
    }

    public List findAll(){
        List list = userMapper.selectAll();
        return list;
    }
}
