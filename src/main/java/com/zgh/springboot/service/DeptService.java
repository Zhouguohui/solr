package com.zgh.springboot.service;

import com.zgh.springboot.entity.Dept;

public interface DeptService {

    public Dept getDept(Integer id);

    public int deleteDeptById(Integer id);

    public int insertDept(Dept dept);

    public int updateDeptById(Dept dept);
}
