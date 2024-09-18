package com.Bottomline.AutoComplete.config;

import com.Bottomline.AutoComplete.model.Employee;
import com.Bottomline.AutoComplete.repository.EmployeeRepository;
import com.Bottomline.AutoComplete.service.AutoCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class DataLoader implements CommandLineRunner {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private AutoCompleteService autoCompleteService;

    @Override
    public void run(String... args) throws Exception {
        //Load initial data from the H2 database to Trie data structure.
        List<Employee> employeeNames = employeeRepository.findAll();
        autoCompleteService.insertEmployeeNames(employeeNames);
    }
}
