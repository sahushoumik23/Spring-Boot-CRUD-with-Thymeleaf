package com.search.service;

import java.util.List;

import com.search.model.Employee;

public interface EmployeeService 
{
    public List<Employee> listAll();
    public List<Employee> listAll(String keyword);
    public void save(Employee employee);    
    public Employee getById(Long id);
    public void delete(Long id);
}
