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
    @Column(nullable = false)
    private RoomType roomType;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    private String area;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comfort_id")
    private RoomComfortEntity roomComfortEntity;
}
