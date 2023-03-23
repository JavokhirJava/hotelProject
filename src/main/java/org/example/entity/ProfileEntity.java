package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Role;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "profile")
public class ProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false,unique = true)
    private String phone;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;
}
