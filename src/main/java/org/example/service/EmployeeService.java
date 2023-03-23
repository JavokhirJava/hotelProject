package org.example.service;

import org.example.entity.EmployeeEntity;
import org.example.entity.EmployeeType;
import org.example.repository.EmployeeRepository;
import org.example.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    EmployeeTypeRepository employeeTypeRepository;

    public void saveEmployee(EmployeeEntity employeeEntity, Integer typeId) {
       EmployeeType employeeType= employeeTypeRepository.getById(typeId);
       if (employeeType==null){
           System.out.println("Type not found");
           return;
       }
       employeeEntity.setEmployeeType(employeeType);
       employeeRepository.save(employeeEntity);
        System.out.println("Saved successfully");
    }

    public void employeeList() {
        employeeRepository.getList().forEach(System.out::println);
    }

    public void delete(Integer id) {
       EmployeeEntity employee = employeeRepository.getById(id);
        if (employee==null){
            System.out.println("Employee not found");
            return;
        }
        employeeRepository.delete(employee);
    }
}
