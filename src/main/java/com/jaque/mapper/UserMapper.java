package com.jaque.mapper;

import java.util.List;

import com.jaque.pojo.User;

public interface UserMapper {
    //void createTable (@Param("tableName") String tableName);
    void insertUser(User user);
    User findUserById(int id);
    void delUserById(int id);
    void updateUserById(User user);
    List<User> findUserByUserName(String username);
}