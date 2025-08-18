package com.yuxiang.design.framework.link.example.repository;

import com.yuxiang.dao.UserDao;
import com.yuxiang.dao.mapper.IUserDao;
import org.springframework.stereotype.Repository;


import javax.annotation.Resource;


@Repository
public class UserRepository implements IUserRepository{
    @Resource
    private IUserDao userDao;

    @Override
    public UserDao queryUserInformationById(String id) {

        return userDao.queryUserInformationById(id);
    }
}
