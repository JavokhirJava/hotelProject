package org.example.service;

import org.example.entity.EmployeeType;
import org.example.entity.RoomComfortEntity;
import org.example.repository.EmployeeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;
    public void add(EmployeeType employeeType) {
        employeeTypeRepository.save(employeeType);
    }

    public void list() {
        employeeTypeRepository.getList().forEach(System.out::println);
    }

    public void delete(Integer id) {
        EmployeeType employeeType = employeeTypeRepository.getById(id);
        if (employeeType==null){
            System.out.println("Not Found");
            return;
        }
        employeeTypeRepository.delete(employeeType);
        System.out.println("Deleted successfully\n");
    }
}
