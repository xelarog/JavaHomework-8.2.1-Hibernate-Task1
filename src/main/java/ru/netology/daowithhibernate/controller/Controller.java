package ru.netology.daowithhibernate.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.service.Service;

import java.util.List;

@RestController
public class Controller implements CommandLineRunner {

    private Service service;

    public Controller(Service service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    public List<Persons> getPersonsByCityOfLiving(@RequestParam("city") String city) {
        return service.getPersonsByCity(city);
    }

    @Override
    public void run(String... args) {
        service.getRepository().addPersons();
    }
}
