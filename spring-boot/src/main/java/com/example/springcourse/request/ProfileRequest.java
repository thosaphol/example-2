package com.example.springcourse.request;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfileRequest {
    private long id;
    private String firstName;

    private String lastName;

    private String phone;
}
