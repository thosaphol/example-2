package com.example.springcourse.service;


import com.example.springcourse.entity.PersonEntity;
import com.example.springcourse.repository.PersonRepository;
import com.example.springcourse.request.PersonTalkRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HelloWorldService {

    private final PersonRepository personRepository;

    public String talk() {
        return "Hello Service";
    }

    public PersonEntity addPersonWhoTalk(String firstname, String lastname, String email, String address, String city, String phone) {
        PersonEntity entity = new PersonEntity();
        entity.setAddress(address);
        entity.setCity(city);
        entity.setEmail(email);
        entity.setFirstname(firstname);
        entity.setLastname(lastname);
        entity.setPhone(phone);

        personRepository.save(entity);
        return entity;
    }

    public List<PersonEntity> addPersonWhoTalks(List<PersonTalkRequest> personTalkRequestList) {
       List<PersonEntity> entities = personTalkRequestList.stream().map(personTalkRequest -> {
            PersonEntity entity = new PersonEntity();
            entity.setAddress(personTalkRequest.getAddress());
            entity.setCity(personTalkRequest.getCity());
            entity.setEmail(personTalkRequest.getEmail());
            entity.setFirstname(personTalkRequest.getFirstname());
            entity.setLastname(personTalkRequest.getLastname());
            entity.setPhone(personTalkRequest.getPhone());
            return entity;
        }).toList();


//        personRepository.save(entity);
        personRepository.saveAll(entities);
        return entities;
    }

    @Transactional
    public PersonEntity updatePersonTalk(PersonEntity entity){

      PersonEntity entity1 =  personRepository.findById(entity.getI()).get();
        entity1.setFirstname(entity.getFirstname());
        return entity;
    }

    public int howManyTalks() {
        return personRepository.findAll().size();
    }

    public PersonEntity delete(long id){
       PersonEntity entity =  personRepository.findById(Long.valueOf(id)).orElse(null);
        personRepository.delete(entity);

        return entity;
    }
}
