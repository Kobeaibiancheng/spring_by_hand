package com.yuxiang.springframework.beans;

public class BeansException extends Throwable{

    String exceptionName;
    Exception e;


    public BeansException(String exceptionName, Exception e) {
        this.exceptionName = exceptionName;
        this.e = e;
    }
}
