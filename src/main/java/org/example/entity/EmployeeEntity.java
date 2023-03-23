package org.example.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.example.enums.Status;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "employee")
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
    @Enumerated(EnumType.STRING)
    private Status status;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private EmployeeType employeeType;
}
