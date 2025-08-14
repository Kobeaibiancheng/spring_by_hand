package com.yuxiang.dao.mapper;

import com.yuxiang.dao.UserDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserDao {
    public UserDao queryUserInformationById(String id);
}
