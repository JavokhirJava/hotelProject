package org.example.service;

import org.example.entity.RoomComfortEntity;
import org.example.entity.RoomEntity;
import org.example.repository.ConvenientRepository;
import org.example.repository.RoomRepository;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ConvenientRepository convenientRepository;
    public void addRoom(RoomEntity roomEntity) {
        roomRepository.save(roomEntity);
    }

    public void roomList() {
        roomRepository.getList().forEach(System.out::println);
    }

    public void deleteRoom(Integer id) {
        RoomEntity roomEntity = roomRepository.getById(id);
        if(roomEntity==null){
            System.out.println("Not Found");
            return;
        }
        roomRepository.delete(roomEntity);
        System.out.println("Deleted successfully");
    }


    public void updateRoom(RoomEntity room) {
        RoomEntity roomEntity = roomRepository.getById(room.getId());
        if (roomEntity == null) {
            System.out.println("Not Found");
            return;
        }
        roomRepository.updateRoom(room);
        System.out.println("Updated successfully");
    }

    public void find(Integer id) {
        RoomEntity roomEntity = roomRepository.getById(id);
        if (roomEntity == null) {
            System.out.println("Not Found");
            return;
        }
        System.out.println(roomEntity);
    }

    public void convenient(Integer rid, Integer cid) {
        RoomEntity roomEntity = roomRepository.getById(rid);
        RoomComfortEntity roomComfortEntity = convenientRepository.getById(cid);
        if (roomEntity == null || roomComfortEntity==null) {
            System.out.println("Not Found");
            return;
        }
        roomEntity.setRoomComfortEntity(roomComfortEntity);
        roomRepository.updateRoom(roomEntity);
        System.out.println("Convenient added successfully");
    }
}
