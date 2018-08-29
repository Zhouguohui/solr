package com.zgh.springboot.service.impl;

import com.zgh.springboot.dao.DeptDao;
import com.zgh.springboot.entity.Dept;
import com.zgh.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeptServiceImpl implements DeptService {


    @Autowired
    DeptDao deptDao;

    @Override
    public Dept getDept(Integer id) {
        return deptDao.getDept(id);
    }

    @Override
    public int deleteDeptById(Integer id) {
        return deptDao.deleteDeptById(id);
    }

    @Override
    public int insertDept(Dept dept) {
        return deptDao.insertDept(dept);
    }

    @Override
    public int updateDeptById(Dept dept) {
        return deptDao.updateDeptById(dept);
    }
}
