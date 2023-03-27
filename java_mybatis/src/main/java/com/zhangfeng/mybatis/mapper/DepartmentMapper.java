package com.zhangfeng.mybatis.mapper;

import com.zhangfeng.mybatis.bean.Department;

public interface DepartmentMapper {

    public Department getDeptById(Integer id);

    public Department getDeptByIdPlus(Integer id);

    public Department getDeptByIdStep(Integer id);
}
