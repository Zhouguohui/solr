package com.zgh.springboot.controller;


import com.zgh.springboot.entity.Users;
import com.zgh.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserContorller {

    @Autowired
    UsersService usersService;

    @RequestMapping("/getUsers/{id}")
    public Users getUsers(@PathVariable("id") Integer id) {

        return usersService.getUsers(id);
    }

    @RequestMapping("deleteUsersById")
    public int deleteUsersById(Integer id) {
        return usersService.deleteUsersById(id);
    }

    @RequestMapping("insertUser")
    public int insertUser(Users users) {
        return usersService.insertUsers(users);
    }

    @RequestMapping("updateUserById")
    public int updateUserById(Users users) {
        return usersService.updateUsersById(users);
    }
}
