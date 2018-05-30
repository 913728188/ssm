package com.lmf.service.impl;

import com.lmf.Mapper.UserMapper;
import com.lmf.entity.User;
import com.lmf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * com.lmf.service.impl
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    public User addUser(User u){
       int count =   userMapper.insert(u);
       return u;
    }
}
