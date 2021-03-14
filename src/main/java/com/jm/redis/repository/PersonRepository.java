package com.jm.redis.repository;

import com.jm.redis.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonRepository
{
    private static final String HASH_KEY = "Person";

    @Qualifier("redisTemplate")
    @Autowired
    private RedisTemplate template;

    public Person save(Person person)
    {
        template.opsForHash().put(HASH_KEY, person.getId(), person);
        return person;
    }

    public List<Person> findAll()
    {
        return template.opsForHash().values(HASH_KEY);
    }

    public Person findById(Long id)
    {
        return (Person) template.opsForHash().get(HASH_KEY, id);
    }

    public void deleteById(Long id)
    {
        template.opsForHash().delete(HASH_KEY, id);
    }
}
