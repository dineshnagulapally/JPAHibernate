package com.example.jpahibernate.Exception;

public class UserNotFound extends RuntimeException{
    public  UserNotFound(String msg){
        super(msg);
    }
}
