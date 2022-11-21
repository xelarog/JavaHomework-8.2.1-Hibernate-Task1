package ru.netology.daowithhibernate.controller;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.service.Service;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/persons/by-age-less-than")
    public List<Persons> getPersonsByAgeLessThan(@RequestParam("age") int age) {
        return service.getPersonsByAgeLessThan(age);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/persons/by-name-and-surname")
    public Persons getPersonByNameAndSurname(@RequestParam("name") String name, @RequestParam("surname") String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }

    @Override

    public void run(String... args) {
        service.getRepository().addPersons();
    }
}
