package com.lmf.service.impl;

import com.lmf.Mapper.UserMapper;
import com.lmf.base.BaseMapper;
import com.lmf.base.BaseServiceImpl;
import com.lmf.entity.User;
import com.lmf.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * com.lmf.service.impl
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/
@Service("UserService")
public class UserServiceImpl  extends BaseServiceImpl<User,Long> implements UserService {


    @Autowired
    private UserMapper userMapper;


    @Override
    @Autowired
    public void setBaseMapper(@Qualifier("userMapper") BaseMapper<User> baseMapper) {
        this.baseMapper = baseMapper;

    }

    public  void setMapper(UserMapper userMapper){
        userMapper = this.userMapper;
    }

    public User addUser(User u){
       int count =   userMapper.insert(u);
       return u;
    }

    public List findAll(){
        List list = userMapper.selectAll();
        return list;
    }

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
    public  User login(String email,String password){
        User u  = userMapper.findByEmailAndPwd(email,password);
        return u;
    }

}
