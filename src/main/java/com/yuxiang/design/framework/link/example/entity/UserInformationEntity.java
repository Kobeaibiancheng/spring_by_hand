package com.yuxiang.design.framework.link.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInformationEntity {
    private String name;
    private int age;
    private String address;
    private String phone;
    private String email;
    private String job;
}
