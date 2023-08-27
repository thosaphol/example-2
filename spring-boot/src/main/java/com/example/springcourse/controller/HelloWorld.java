package com.example.springcourse.controller;


import com.example.springcourse.entity.PersonEntity;
import com.example.springcourse.request.HelloWorldRequest;
import com.example.springcourse.request.PersonTalkRequest;
import com.example.springcourse.response.HelloWorldResponse;
import com.example.springcourse.service.HelloWorldService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/hello")

@Log4j2

@RequiredArgsConstructor
public class HelloWorld {


    private final HelloWorldService helloWorldService;

    @GetMapping()
    public String sayHello() {
        return helloWorldService.talk();
    }

    @PostMapping()
    public ResponseEntity<?> sayPostHello(@RequestBody HelloWorldRequest req) {
        log.debug("name {}", req.getName());
        HelloWorldResponse res = new HelloWorldResponse();
        res.setText("response hello world for : " + req.getName());
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @PostMapping(path = "/add-person-talk")
    public ResponseEntity<?> addPersonTalk(@RequestBody PersonTalkRequest request) {
        PersonEntity entity = helloWorldService.addPersonWhoTalk(
                request.getFirstname(),
                request.getLastname(),
                request.getEmail(),
                request.getAddress(),
                request.getCity(),
                request.getPhone()
        );

        return new ResponseEntity<>(entity, HttpStatus.CREATED);
    }

    @PostMapping(path = "/add-person-talks")
    public ResponseEntity<?> adPersonTalks(@RequestBody List<PersonTalkRequest> reqs) {
        List<PersonEntity> entities = helloWorldService.addPersonWhoTalks(reqs);
        return new ResponseEntity<>(entities, HttpStatus.CREATED);
    }

    @PostMapping(path = "update-person-talk")
    public ResponseEntity<?> updatePersonTalk(@RequestBody PersonTalkRequest request) {
        PersonEntity entity = new PersonEntity();
        entity.setFirstname(request.getFirstname());
        entity.setLastname(request.getLastname());
        entity.setEmail(
                request.getEmail());
        entity.setAddress(request.getAddress());
        entity.setCity(
                request.getCity());
        entity.setPhone(
                request.getPhone());
        entity.setI(1l);

        helloWorldService.updatePersonTalk(entity);
        return new ResponseEntity<>(entity,HttpStatus.OK);
    }

    @GetMapping(path = "/how-many-talk")
    public ResponseEntity<?> getHowManyTalk() {
        int manyTalk = helloWorldService.howManyTalks();
        return new ResponseEntity<>(manyTalk, HttpStatus.OK);
    }

    @DeleteMapping(path = "/delete")
    public ResponseEntity<?> delete(@RequestBody String id){
log.debug("id : {}",id);
      PersonEntity entity =  helloWorldService.delete(Long.parseLong(id));
      return new ResponseEntity<>(entity,HttpStatus.OK);

    }
}
