package com.zgh.springboot.controller;


import com.zgh.springboot.entity.Users;
import com.zgh.springboot.service.DeptService;
import com.zgh.springboot.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Transactional
public class UserContorller {

   private static final Logger logger =LoggerFactory.getLogger(UserContorller.class);

    @Autowired
    UsersService usersService;

    @Autowired
    DeptService deptService;

    @RequestMapping("/getUsers/{id}")
    public Users getUsers(@PathVariable("id") Integer id) {
        logger.info("你好呀");
        deptService.getDept(id);
        return usersService.getUsers(id);

    }

    @RequestMapping("deleteUsersById")
    public int deleteUsersById(Integer id) {
        usersService.deleteUsersById(id);
        deptService.deleteDeptById(id);
        return 0;
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
