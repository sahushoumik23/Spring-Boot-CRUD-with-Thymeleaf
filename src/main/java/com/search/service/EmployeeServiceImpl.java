package com.search.service;

import java.util.List;

import com.search.model.Employee;
import com.search.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService
{
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> listAll()
    {
        return employeeRepository.findAll();
    }
    @Override
    public List<Employee> listAll(String keyword)
    {
        if(keyword!=null)
            return employeeRepository.findAll(keyword);
        return employeeRepository.findAll();
    }

    @Override
    public void save(Employee employee) 
    {
        employeeRepository.save(employee);
    }

    @Override
    public Employee getById(Long id) 
    {
        return employeeRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) 
    {
        employeeRepository.deleteById(id);
    }

    

}
