package com.zgh.springboot.dao;

import com.zgh.springboot.entity.Users;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UsersDao {

    public Users getUsers(Integer id);

    public int deleteUsersById(Integer id);

    public int insertUsers(Users users);

    public int updateUsersById(Users users);


}
