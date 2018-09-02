package com.zgh.springboot.dao;

import com.zgh.springboot.entity.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UsersDao {

    public Users getUsers(Integer id);

    public int deleteUsersById(Integer id);

    public int insertUsers(Users users);

    public int updateUsersById(Users users);

    public List<Users> getSelectUser(Users users);


}
