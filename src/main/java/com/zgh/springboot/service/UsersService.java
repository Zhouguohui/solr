package com.zgh.springboot.service;

import com.zgh.springboot.entity.Users;

import java.util.List;

public interface UsersService {
    public Users getUsers(Integer id);

    public int deleteUsersById(Integer id);

    public int insertUsers(Users users);

    public int updateUsersById(Users users);

    public  List<Users> getSelectUser(Users users,Integer pageSize, Integer pageNum);
}
