package org.example.controller;

import org.example.entity.RoomComfortEntity;
import org.example.scanner.NumScanner;
import org.example.service.ConvenientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class ConvenientController {
    @Autowired
    private NumScanner numScanner;
    @Autowired
    private ConvenientService convenientService;

    public void start() {
        boolean b = true;
        while (b){
            switch (menu()){
                case 1 -> cAdd();
                case 2 -> cList();
                case 3 -> cDelete();
                default -> b=false;
            }
        }
    }

    private void cDelete() {
        System.out.println("Enter Id");
        Integer id = numScanner.getNumScanner().nextInt();
        convenientService.delete(id);
    }

    private void cList() {
        convenientService.cList();
    }

    private void cAdd() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter Name:");
        String name = scanner.nextLine();

        RoomComfortEntity roomComfortEntity = new RoomComfortEntity();
        roomComfortEntity.setType(name);
        convenientService.add(roomComfortEntity);
    }


    private Integer menu() {
        System.out.println("1.Add Convenient");
        System.out.println("2.Convenient List");
        System.out.println("3.Delete Convenient");
        return numScanner.getNumScanner().nextInt();
    }
}

