package com.example.demo.controller;

import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    private final Logger LOG = LoggerFactory.getLogger(getClass().getName());

    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public Person createPerson(@RequestBody Person person) {
        LOG.info("Saving Person: {}.", person);
        personRepository.save(person);
        LOG.info("Person saved: {}.", person);
        return person;
    }

    /*@RequestMapping(value = "/{personId}", method = RequestMethod.GET)
    public Person getPerson(@PathVariable Long personId) {
        Person person = personRepository.findOne(personId);
        LOG.info("Got person from DB: {}.", person);
        return person;
    }*/

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Person> getAllPerson() {
        List<Person> persons = personRepository.findAll();
        LOG.info("Getting all Data: {}.", persons);
        return persons;
    }

}
