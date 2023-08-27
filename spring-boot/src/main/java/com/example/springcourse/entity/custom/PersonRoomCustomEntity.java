package com.example.springcourse.entity.custom;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class PersonRoomCustomEntity {

    @Id
    @Column(name = "id")
    private Long I;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "roomname")
    private String roomname;

    @Column(name = "seat")
    private String seat;
}
