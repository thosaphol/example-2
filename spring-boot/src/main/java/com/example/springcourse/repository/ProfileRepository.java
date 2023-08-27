package com.example.springcourse.repository;

import com.example.springcourse.entity.PersonEntity;
import com.example.springcourse.entity.ProfileEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProfileRepository extends CrudRepository<ProfileEntity,Long> {
    public List<ProfileEntity> findAll();
    public ProfileEntity findById(long id);

}
