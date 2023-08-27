package com.example.springcourse.response;


import com.example.springcourse.entity.ProfileEntity;
import lombok.Data;

@Data
public class ProfileResponse {
    public ProfileResponse(ProfileEntity entity){
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        phone = entity.getPhone();
    }
    public ProfileResponse(){

    }

    private String firstName;

    private String lastName;

    private String phone;

}
