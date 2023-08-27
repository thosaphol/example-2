package com.example.springcourse.service;


import com.example.springcourse.entity.ProfileEntity;
import com.example.springcourse.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileService {

    private final ProfileRepository personRepository;

    public List<ProfileEntity> findAll() {
        return personRepository.findAll();
    }

    public ProfileEntity findById(long id) {
        return personRepository.findById(id);
    }

    public ProfileEntity addProfile(String firstname, String lastname, String phone) {
        ProfileEntity entity = new ProfileEntity(firstname, lastname, phone);
        personRepository.save(entity);
        return entity;
    }

    @Transactional
    public ProfileEntity updateProfile(ProfileEntity entity) {
        ProfileEntity updateEntity = personRepository.findById(entity.getId());
        try{
            updateEntity.saveWithEntity(entity);
        }catch (NullPointerException ex){
            ex.printStackTrace();
            return null;
        }
        return updateEntity;
    }
}
