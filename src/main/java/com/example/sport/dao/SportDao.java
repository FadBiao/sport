package com.example.sport.dao;



import com.example.sport.entity.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SportDao {

    public static final String HASH_KEY = "Sport";
    @Autowired
    private RedisTemplate template;

    public Sport save(Sport sport){
        template.opsForHash().put(HASH_KEY,sport.getId(),sport);
        return sport;
    }

    public List<Sport> findAll(){
        return template.opsForHash().values(HASH_KEY);
    }

    public Sport findSportById(int id){
        return (Sport) template.opsForHash().get(HASH_KEY,id);
    }


    public String deleteSport(int id){
        template.opsForHash().delete(HASH_KEY,id);
        return "product removed !!";
    }
}