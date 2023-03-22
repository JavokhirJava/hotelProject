package org.example.db;

import org.example.config.Config;
import org.example.entity.ProfileEntity;
import org.example.enums.Role;
import org.example.repository.ProfileRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Init {
    public static void saveAdmin() {
        ProfileEntity profile = new ProfileEntity();
        profile.setName("Admin");
        profile.setPhone("111");
        profile.setRole(Role.ADMIN);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);
        ProfileRepository profileRepository = (ProfileRepository) applicationContext.getBean("profileRepository");
        profileRepository.save(profile);
    }
}
