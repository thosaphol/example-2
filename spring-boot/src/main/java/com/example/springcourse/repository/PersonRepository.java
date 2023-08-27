package com.example.springcourse.repository;

import com.example.springcourse.entity.PersonEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<PersonEntity,Long> {
//    public List<PersonEntity> findByFirstname(String firstname);
public PersonEntity findByFirstname(String firstname);
    public List<PersonEntity> findByEmail(String email);
    public List<PersonEntity> findAll();
    public List<PersonEntity> findByFirstnameAndLastname(String firstname, String lastname);

    @Query(value = "select * from person where id=:id", nativeQuery = true)
    public List<PersonEntity> getAllPerson(Long id);
}
