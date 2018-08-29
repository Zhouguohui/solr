package com.zgh.springboot.dao;

import org.apache.ibatis.annotations.*;
import com.zgh.springboot.entity.Dept;

@Mapper
public interface DeptDao {

    @Select("select * from dept where id= #{id}")
    public Dept getDept(Integer id);

    @Delete("delete from dept where id = #{id}")
    public int deleteDeptById(Integer id);

    @Options(useGeneratedKeys = true,keyProperty = "id")
    @Insert("insert into dept (dept_name) values (#{deptName})")
    public int insertDept(Dept dept);

    @Update("update dept set dept_name = #{deptName} where id = #{id}")
    public int updateDeptById(Dept dept);

}
