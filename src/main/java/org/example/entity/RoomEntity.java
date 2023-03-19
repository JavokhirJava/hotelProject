package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.RoomType;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "floor_num",nullable = false)
    private Integer floorNum;
    @Enumerated(EnumType.STRING)
    private RoomType roomType;
    private Double price;
    private String area;

}
