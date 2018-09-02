package com.zgh.springboot.service.impl;

import com.github.pagehelper.PageHelper;
import com.zgh.springboot.dao.UsersDao;
import com.zgh.springboot.entity.Users;
import com.zgh.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UsersService {

    @Autowired
    UsersDao usersDao;


    @Override
    public Users getUsers(Integer id) {

        return usersDao.getUsers(id);
    }

    @Override
    public int deleteUsersById(Integer id) {
        return usersDao.deleteUsersById(id);
    }

    @Override
    public int insertUsers(Users users) {
        return usersDao.insertUsers(users);
    }

    @Override
    public int updateUsersById(Users users) {
        return usersDao.updateUsersById(users);
    }

    @Override
    public List<Users> getSelectUser(Users users, Integer pageSize, Integer pageNum) {

        PageHelper.startPage(pageNum,pageSize);
        return usersDao.getSelectUser(users);
    }
}
