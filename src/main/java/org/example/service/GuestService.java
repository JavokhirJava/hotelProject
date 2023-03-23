package org.example.service;

import org.example.entity.GuestEntity;
import org.example.entity.PassportEntity;
import org.example.repository.GuestRepository;
import org.example.repository.PassportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GuestService {
    @Autowired
    PassportRepository passportRepository;
    @Autowired
    GuestRepository guestRepository;

    public void addGuest(GuestEntity guest, PassportEntity passport) {
        passportRepository.save(passport);
        guest.setPassport(passport);
        guestRepository.save(guest);
        System.out.println("Guest Added");
    }

    public void getList() {
        guestRepository.getList().forEach(System.out::println);
    }
}
