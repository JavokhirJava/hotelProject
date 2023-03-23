package org.example.controller;

import org.example.scanner.NumScanner;
import org.example.scanner.StringScanner;
import org.example.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.Scanner;

@Controller
public class RoomController {
    @Autowired
    private NumScanner numScanner;
    @Autowired
    private RoomService roomService;

    public void start() {
        boolean b = true;
        while (b){
            switch (menu()){
                case 1 -> addRoom();
                case 2 -> roomList();
                case 3 -> deleteRoom();
                case 4 -> update();
                case 5 -> find();
                case 6 -> convenient();
                default -> b=false;
            }
        }
    }

    private void convenient() {
    }

    private void find() {
    }

    private void update() {
    }

    private void deleteRoom() {
    }

    private void roomList() {
    }

    private void addRoom() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter floor number");
        Integer floor = numScanner.getNumScanner().nextInt();
        System.out.println("Choose room type ->ORDINARY,LUX,DOUBLE_ROOM,FAMILY_ROOM,PRESIDENT_ROOM");
        String type = scanner.nextLine().toUpperCase();
        System.out.println("Enter price");
        Double price = numScanner.getNumScanner().nextDouble();
        System.out.println("Enter area");
        String area = scanner.nextLine();

    }

    private Integer menu() {
        System.out.println("1.Room Add");
        System.out.println("2.Room List");
        System.out.println("3.Delete Room");
        System.out.println("4.Update");
        System.out.println("5.Find");
        System.out.println("6.Room convenient");
        return numScanner.getNumScanner().nextInt();
    }
}
