package com.zgh.springboot.controller;


import com.alibaba.fastjson.JSON;
import com.zgh.springboot.common.RestResult;
import com.zgh.springboot.entity.Users;
import com.zgh.springboot.service.DeptService;
import com.zgh.springboot.service.UsersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.JedisCluster;


@Controller
@ResponseBody
@RequestMapping("/users")
public class UserContorller {

   private static final Logger logger =LoggerFactory.getLogger(UserContorller.class);

    @Autowired
    UsersService usersService;

    @Autowired
    DeptService deptService;

    @Autowired
    JedisCluster jedisCluster;


    @RequestMapping("/getSelectUser")
    public RestResult getSelectUser(Users users,Integer pageSize,Integer pageNum){
      return RestResult.build(usersService.getSelectUser(users,pageSize,pageNum));
    }

    @RequestMapping("/getUsers/{id}")
    public RestResult getUsers(@PathVariable("id") Integer id) {

       /* Users u = null;
        if(jedisCluster.exists(String.valueOf(id))){
            u = JSON.parseObject(jedisCluster.get(String.valueOf(id)),Users.class);
        }else{
            u = usersService.getUsers(id);
        }*/

       Users user = usersService.getUsers(id);
       if(null==user){
           return RestResult.Fail("用户不存在");
       }
        return RestResult.build(usersService.getUsers(id));

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
