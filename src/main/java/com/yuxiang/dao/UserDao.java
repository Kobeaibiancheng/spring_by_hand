package com.yuxiang.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDao {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String job;
}
