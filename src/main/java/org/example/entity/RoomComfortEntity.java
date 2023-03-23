package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@ToString
@Getter
@Setter
@Entity
@Table(name = "comfort")
public class RoomComfortEntity {
@Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
private Integer id;
@Column(nullable = false)
private String type;
}
