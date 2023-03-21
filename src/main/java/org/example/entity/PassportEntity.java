package org.example.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "passport")
public class PassportEntity {
    @Id
    private String pass_id;
    @Column(name = "g_place",nullable = false)
    private String given_place;
    @Column(nullable = false)
    private LocalDate given_time;
}
