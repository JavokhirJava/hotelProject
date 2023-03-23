package org.example.controller;

import org.example.entity.EmployeeType;
import org.example.entity.RoomComfortEntity;
import org.example.scanner.NumScanner;
import org.example.service.EmployeeTypeService;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class EmployeeTypeController {
    @Autowired
    private NumScanner numScanner;
    @Autowired
    private EmployeeTypeService employeeTypeService;

    public void start() {
        boolean b = true;
        while (b){
            switch (menu()){
                case 1 -> eAdd();
                case 2 -> eList();
                case 3 -> eDelete();
                default -> b=false;
            }
        }
    }

    private void eDelete() {
        System.out.println("Enter Id");
        Integer id = numScanner.getNumScanner().nextInt();
        employeeTypeService.delete(id);
    }

    private void eList() {
        employeeTypeService.list();
    }

    private void eAdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Type:");
        String name = scanner.nextLine();

        EmployeeType employeeType = new EmployeeType();
        employeeType.setType(name);
        employeeTypeService.add(employeeType);
    }

    private Integer menu() {
        System.out.println("1.Add Type");
        System.out.println("2.Type List");
        System.out.println("3.Delete Type");
        return numScanner.getNumScanner().nextInt();
    }
}
