package org.example.controller;

import org.example.container.ComponentContainer;
import org.example.scanner.NumScanner;
import org.example.scanner.StringScanner;
import org.example.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {
    @Autowired
    StringScanner stringScanner;
    @Autowired
    NumScanner numScanner;
    @Autowired
    AuthService authService;

    public void start() {
        boolean b = true;
        while (b) {
            switch (menu()) {
                case 1 -> login();
                default -> b = false;
            }
        }
    }

    public void login(){
        System.out.println("Please enter phone number !!!");
        String phone = stringScanner.getStringScanner().next();
        authService.login(phone);
    }

    private Integer menu() {
        System.out.println("*!* Menu *!*");
        System.out.println("1.Login");
        System.out.println("0.Exit");
        Integer n = numScanner.getNumScanner().nextInt();
        return n;
    }
}
