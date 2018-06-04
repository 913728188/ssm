package com.lmf.service;

import com.lmf.base.BaseService;
import com.lmf.entity.User;

import java.util.List;

/**
 * com.lmf.service
 * <p>
 * root创建于18-5-30
 * TODO:进行描述
 **/
public interface UserService extends BaseService<User,Long>{
    User addUser(User u);

     List findAll();

    /**
     * 登录
     * @param email
     * @param password
     * @return
     */
     User login(String email,String password);

}
