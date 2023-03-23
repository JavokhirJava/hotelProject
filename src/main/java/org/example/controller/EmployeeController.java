package org.example.controller;

import org.example.entity.EmployeeEntity;
import org.example.enums.Status;
import org.example.scanner.NumScanner;
import org.example.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class EmployeeController {
    @Autowired
    private NumScanner numScanner;
    @Autowired
    private EmployeeService employeeService;
    public void start() {
        boolean b = true;
        while (b){
            switch (menu()){
                case 1 -> employeeAdd();
                case 2 -> employeeList();
                case 3 -> employeeDelete();
                default -> b=false;
            }
        }
    }

    private void employeeDelete() {
        System.out.println("Enter id");
        Integer id = numScanner.getNumScanner().nextInt();
        employeeService.delete(id);
    }

    private void employeeList() {
        employeeService.employeeList();
    }

    private void employeeAdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter surname");
        String surname = scanner.nextLine();
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        System.out.println("Enter birthday");
        String birthday = scanner.nextLine();
        System.out.println("Enter Type Id");
        Integer type_id = numScanner.getNumScanner().nextInt();

        EmployeeEntity employeeEntity = new EmployeeEntity();
        employeeEntity.setName(name);
        employeeEntity.setSurname(surname);
        employeeEntity.setPhone(phone);
        employeeEntity.setStatus(Status.ACTIVE);
        employeeEntity.setBornYear(birthday);
        employeeService.saveEmployee(employeeEntity,type_id);
    }

    private Integer menu() {
        System.out.println("1.Add Employee");
        System.out.println("2.Employee List");
        System.out.println("3.Delete Employee");
        return numScanner.getNumScanner().nextInt();
    }
}
