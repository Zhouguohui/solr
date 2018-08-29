package com.zgh.springboot.controller;


import com.zgh.springboot.entity.Users;
import com.zgh.springboot.service.DeptService;
import com.zgh.springboot.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Transactional
public class UserContorller {

    @Autowired
    UsersService usersService;

    @Autowired
    DeptService deptService;

    @RequestMapping("/getUsers/{id}")
    public Users getUsers(@PathVariable("id") Integer id) {

        return usersService.getUsers(id);
    }

    @RequestMapping("deleteUsersById")
    public int deleteUsersById(Integer id) {
        usersService.deleteUsersById(id);
        deptService.deleteDeptById(id);
      int j = 1/0;
        return j;
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
