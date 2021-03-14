package com.jm.redis.controller;

import com.jm.redis.entity.Person;
import com.jm.redis.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonMapping
{
    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public List<Person> findAll()
    {
        return personRepository.findAll();
    }

    @PostMapping
    public Person save(@RequestBody Person person)
    {
        return personRepository.save(person);
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id)
    {
        return personRepository.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id)
    {
        personRepository.deleteById(id);
    }
}
