package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
@Getter
@Setter
@Entity
@Table(name = "gueset")
public class GuestEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false,unique = true)
    private String phone;
//    @Column(name = "passport_id")
//    private Integer passportID;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "passport_id")
    private PassportEntity passport;
}
