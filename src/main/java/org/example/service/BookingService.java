package org.example.service;

import org.example.entity.BookingEntity;
import org.example.entity.GuestEntity;
import org.example.entity.RoomEntity;
import org.example.repository.BookingRepository;
import org.example.repository.GuestRepository;
import org.example.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    @Autowired
    GuestRepository guestRepository;
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    BookingRepository bookingRepository;
    public void addBooking(Integer guestId, Integer roomId, BookingEntity bookingEntity) {
        GuestEntity guest = guestRepository.getById(guestId);
        RoomEntity roomEntity = roomRepository.getById(roomId);
        Integer days = Integer.valueOf(bookingEntity.getBookingDay());
        Double payment = roomEntity.getPrice()*days;
        bookingEntity.setGuestEntity(guest);
        bookingEntity.setRoomEntity(roomEntity);
        bookingEntity.setPaymentAmount(payment);
        bookingRepository.save(bookingEntity);
    }

    public void getList() {
        bookingRepository.getList().forEach(System.out::println);
    }
}
