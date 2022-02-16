package com.search.repository;

import java.util.List;

import com.search.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long>
{
    @Query("SELECT p FROM Employee p WHERE p.fname LIKE %?1%"
    +"OR p.lname LIKE %?1%"
    +"OR p.email LIKE %?1%"
    +"OR p.role LIKE %?1%"
    )
    public List<Employee> findAll(String keyword);
}
