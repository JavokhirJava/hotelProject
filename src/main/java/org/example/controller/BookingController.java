package org.example.controller;

import org.example.entity.BookingEntity;
import org.example.scanner.NumScanner;
import org.example.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.Scanner;

@Controller
public class BookingController {
    @Autowired
    NumScanner numScanner;
    @Autowired
    BookingService bookingService;
    public void start() {
        boolean b = true;
        while (b){
            switch (menu()){
                case 1 -> makeBooking();
                case 2 -> bookingList();
                case 3 -> bookingListRoomId();
                case 4 -> bookingListGuestId();
                default -> b=false;
            }
        }
    }

    private void bookingListGuestId() {
    }

    private void bookingListRoomId() {
    }

    private void bookingList() {
        bookingService.getList();
    }

    private void makeBooking() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter guest id");
        Integer guestId = numScanner.getNumScanner().nextInt();
        System.out.println("Enter room id");
        Integer roomId = numScanner.getNumScanner().nextInt();
        System.out.println("Enter Booking Date");
        LocalDateTime date = LocalDateTime.now();
        System.out.println("Enter amount of days");
        String amount = scanner.nextLine();
        BookingEntity  bookingEntity = new BookingEntity();
        bookingEntity.setBookingDay(amount);
        bookingEntity.setStartedDate(date);
        bookingService.addBooking(guestId,roomId,bookingEntity);
    }


    private Integer menu() {
        System.out.println("1.Make Booking");
        System.out.println("2.Booking list");
        System.out.println("3.Booking by Room id");
        System.out.println("4.Booking by Guest id");
        return numScanner.getNumScanner().nextInt();
    }
}
