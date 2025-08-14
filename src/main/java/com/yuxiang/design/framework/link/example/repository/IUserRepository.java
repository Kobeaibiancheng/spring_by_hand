package com.yuxiang.design.framework.link.example.repository;

import com.yuxiang.dao.UserDao;

public interface IUserRepository {
    public UserDao queryUserInformationById(String id);
}
