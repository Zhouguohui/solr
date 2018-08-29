package com.zgh.springboot.service;

import com.zgh.springboot.entity.Users;

public interface UsersService {
    public Users getUsers(Integer id);

    public int deleteUsersById(Integer id);

    public int insertUsers(Users users);

    public int updateUsersById(Users users);
}
