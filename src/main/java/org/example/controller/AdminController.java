package org.example.controller;

import org.example.scanner.NumScanner;
import org.example.scanner.StringScanner;
import org.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {
    @Autowired
    private NumScanner numScanner;
    @Autowired
    private StringScanner stringScanner;
    @Autowired
    private AdminService adminService;
    @Autowired
    private RoomController roomController;
    @Autowired
    private ConvenientController convenientController;
    @Autowired
    private EmployeeTypeController employeeTypeController;
    @Autowired
    private EmployeeController employeeController;


    public void start() {
        boolean b = true;
        while (b) {
            switch (menu()) {
                case 1 -> roomMenu();
                case 2 -> convenientMenu();
                case 3 -> employeeType();
                case 4 -> employee();
//                case 5 -> guests();
//                case 6 -> booking();
//                case 7 -> outCome();
//                case 8 -> cleanedRooms();
//                case 9 -> complaints();
                default -> b = false;
            }
        }
    }

    private void employee() {
        employeeController.start();
    }

    private void employeeType() {
        employeeTypeController.start();
    }

    private void convenientMenu() {
        convenientController.start();
    }

    private void roomMenu() {
        roomController.start();
    }

    private Integer menu() {
        System.out.println("1.Room Menu");
        System.out.println("2.Convenient(qulayliklar) Menu");
        System.out.println("3.Employee Type Menu");
        System.out.println("4.Employee Menu");
        System.out.println("5.Guest Menu");
        System.out.println("6.Booking Menu");
        System.out.println("7.OutCome Menu");
        System.out.println("8.Cleaned Rooms Menu");
        System.out.println("9.Complaints Menu");
        System.out.println("Choose :");
        return numScanner.getNumScanner().nextInt();
    }
}
