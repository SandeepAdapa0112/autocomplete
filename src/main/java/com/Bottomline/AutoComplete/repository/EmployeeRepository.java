package com.Bottomline.AutoComplete.repository;

import com.Bottomline.AutoComplete.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,String> {
}
