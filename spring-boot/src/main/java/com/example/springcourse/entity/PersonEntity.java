package com.example.springcourse.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter

@Table(name = "person")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long i;

    @Column(name = "firstname",length = 50)
    private String firstname;

    @Column(name = "lastname",length = 50)
    private String lastname;

    @Column(name = "address",length = 50)
    private String address;

    @Column(name = "city",length = 50)
    private String city;

    @Column(name = "phone",length = 15)
    private String phone;

    @Column(name = "email",length = 50)
    private String email;
}
