package com.example.springcourse.entity;

import com.example.springcourse.request.ProfileRequest;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "person")

public class ProfileEntity {
    public ProfileEntity(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public ProfileEntity(ProfileRequest req){
        id = req.getId();
        firstName = req.getFirstName();
        lastName = req.getLastName();
        phone = req.getPhone();
    }
    public ProfileEntity(){}

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "phone")
    private String phone;

    public void saveWithEntity(ProfileEntity entity){
        setPhone(entity.phone);
        setFirstName(entity.firstName);
        setLastName(entity.lastName);
    }
}
