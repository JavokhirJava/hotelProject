package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Getter
@Setter
@Entity
@Table(name = "comfort")
public class RoomComfortEntity {
@Id
private Integer id;
private String type;
}
