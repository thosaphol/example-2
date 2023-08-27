package com.example.springcourse.controller;


import com.example.springcourse.entity.ProfileEntity;
import com.example.springcourse.request.ProfileRequest;
import com.example.springcourse.response.ProfileResponse;
import com.example.springcourse.service.ProfileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "profiles")
@RequiredArgsConstructor
@Log4j2
public class Profile {

    private final ProfileService service;


    @GetMapping
    public ResponseEntity<?> getProfiles(){
        List<ProfileEntity> profiles = service.findAll();
        List<ProfileResponse> responseList = profiles.stream().map(profile ->
             new ProfileResponse(profile)
          ).toList();
        return new ResponseEntity<>(responseList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> updateProfile(@RequestBody ProfileRequest req){
        ProfileEntity entity = new ProfileEntity(req);
        ProfileEntity updateEntity = service.updateProfile(entity);
        if(updateEntity == null) {
            return new ResponseEntity<>(updateEntity,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(updateEntity,HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> addProfile(@RequestBody ProfileRequest req){

        ProfileEntity newProfileEntity = service.addProfile(req.getFirstName(),req.getLastName(),req.getPhone());
        return new ResponseEntity<>(newProfileEntity, HttpStatus.MULTI_STATUS);
    }
}
