package com.example.springcourse.request;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class PersonTalkRequest {


    private String firstname;


    private String lastname;


    private String address;


    private String city;


    private String phone;


    private String email;
}
