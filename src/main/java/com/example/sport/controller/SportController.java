package com.example.sport.controller;

import com.example.sport.dao.SportDao;
import com.example.sport.entity.Sport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sport")
public class SportController {

        @Autowired
        private SportDao dao;

        @PostMapping
        public Sport save(@RequestBody Sport sport) {
            return dao.save(sport);
        }

        @GetMapping
        public List<Sport> getAllSports() {
            return dao.findAll();
        }

        @GetMapping("/{id}")
        public Sport findProduct(@PathVariable int id) {
            return dao.findSportById(id);
        }
        @DeleteMapping("/{id}")
        public String remove(@PathVariable int id)   {
            return dao.deleteSport(id);
    }

}
