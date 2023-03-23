package org.example.controller;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.scanner.NumScanner;
import org.example.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.Scanner;

@Controller
public class GuestController {
    @Autowired
    private NumScanner numScanner;
    @Autowired
    private GuestService guestService;
    public void start() {
        boolean b = true;
        while (b){
            switch (menu()){
                case 1 -> addGuest();
                case 2 -> guestList();
                default -> b=false;
            }
        }
    }

    private void guestList() {
        guestService.getList();
    }

    private void addGuest() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter surname");
        String surname = scanner.nextLine();
        System.out.println("Enter phone");
        String phone = scanner.nextLine();
        GuestEntity guest = new GuestEntity();
        guest.setName(name);
        guest.setSurname(surname);
        guest.setPhone(phone);

        System.out.println("Enter passport number");
        String num = scanner.nextLine();
        System.out.println("Enter passport given date");
        String gDate = scanner.nextLine();
        System.out.println("Enter passport exp date");
        String expDate = scanner.nextLine();
        System.out.println("Given By");
        String givenBy= scanner.next();
        PassportEntity passport = new PassportEntity();
        passport.setPass_id(num);
        passport.setGiven_time(LocalDate.parse(gDate));
        passport.setExp_date(LocalDate.parse(expDate));
        passport.setGiven_place(givenBy);

        guestService.addGuest(guest,passport);
    }

    private Integer menu() {
        System.out.println("1.Add Guest");
        System.out.println("2.Guest List");
        return numScanner.getNumScanner().nextInt();
    }
}
