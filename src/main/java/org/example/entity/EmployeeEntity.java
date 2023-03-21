package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import org.example.enums.Status;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table
public class EmployeeEntity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String surname;
    @Column(nullable = false,unique = true)
    private String phone;
    @Column(name = "born_year",nullable = false)
    private String bornYear;
    @Column(nullable = false)
    private Status status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeType employeeType;
}
