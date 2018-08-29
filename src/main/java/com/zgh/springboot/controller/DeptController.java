package com.zgh.springboot.controller;

import com.zgh.springboot.entity.Dept;
import com.zgh.springboot.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value={"dept","zgh"})
public class DeptController {

    @Autowired
    DeptService deptService;

    @RequestMapping("getDept/{id}")
    public Dept getDept(@PathVariable("id") Integer id) {
        return deptService.getDept(id);
    }

    @RequestMapping("deleteDeptById")
    public int deleteDeptById(Integer id) {
        return deptService.deleteDeptById(id);
    }

    @RequestMapping("insertDept")
    public int insertDept(Dept dept) {
        return deptService.insertDept(dept);
    }

    @RequestMapping("updateDeptById")
    public int updateDeptById(Dept dept) {
        return deptService.updateDeptById(dept);
    }

}
