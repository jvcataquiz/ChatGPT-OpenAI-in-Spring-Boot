package com.example.demo.mapper;

import com.example.demo.entity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {

    List<Employee> employeeList();
}
