package org.example.service;

import org.example.entity.RoomComfortEntity;
import org.example.repository.ConvenientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvenientService {
    @Autowired
    ConvenientRepository convenientRepository;

    public void add(RoomComfortEntity roomComfortEntity) {
        convenientRepository.save(roomComfortEntity);
    }

    public void cList() {
        convenientRepository.getList().forEach(System.out::println);
    }

    public void delete(Integer id) {
        RoomComfortEntity roomComfortEntity = convenientRepository.getById(id);
        if (roomComfortEntity==null){
            System.out.println("Not Found");
            return;
        }
        convenientRepository.delete(roomComfortEntity);
    }
}
