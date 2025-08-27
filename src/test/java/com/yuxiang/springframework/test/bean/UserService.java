package com.yuxiang.springframework.test.bean;

public class UserService {

    private String name;

    public UserService(String name) {
        this.name = name;
    }

    /*private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }*/

    public UserService() {
    }



    public void queryUserInfo() {
        System.out.println("查询用户信息：" + name);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }

    /*@Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("");
        sb.append("").append(name);
        return sb.toString();
    }*/
}
