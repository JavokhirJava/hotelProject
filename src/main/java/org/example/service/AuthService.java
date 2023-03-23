package org.example.service;

import org.example.container.ComponentContainer;
import org.example.controller.AdminController;
import org.example.entity.ProfileEntity;
import org.example.enums.Role;
import org.example.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    @Autowired
    ProfileRepository profileRepository;
    @Autowired
    AdminController adminController;
    public void login(String phone) {
        ProfileEntity profile = profileRepository.getByPhone(phone);
        if (profile == null) {
            System.out.println("User with this number does not exist !!!");
        } else if (profile.getRole().equals(Role.ADMIN)) {
            adminController.start();
        } else if (profile.getRole().equals(Role.USER)) {
            ComponentContainer.profile = profile;
//            userController.start();
        }else {
                System.out.println("Your account has been blocked, please contact your administrator!!!");
            }
        }
    }

