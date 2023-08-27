package com.example.springcourse.dao;


import com.example.springcourse.entity.custom.PersonCustomEntity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@RequiredArgsConstructor
public class PersonDao {

    private final EntityManager entityManager;


    public PersonCustomEntity getPersonCustomEntityById(Long id){
     Query query = entityManager.createNativeQuery("SELECT id,firstname,lastname FROM person WHERE id =:id",PersonCustomEntity.class);
        query.setParameter("id",id);
        return (PersonCustomEntity) query.getSingleResult();
    }

    @Transactional
    public void updatePersonById(Long id) {
        entityManager.createNativeQuery("update person set firstname = 'test' where id =:id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
