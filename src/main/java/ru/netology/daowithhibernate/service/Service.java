package ru.netology.daowithhibernate.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.repository.Repository;
import ru.netology.exception.NotFoundException;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    private Repository repository;

    public List<Persons> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

    public List<Persons> getPersonsByAgeLessThan(int age) {
        return repository.getPersonsByAgeLessThan(age);
    }

    public Persons getPersonByNameAndSurname(String name, String surname) {
        return repository.getPersonByNameAndSurname(name, surname).orElseThrow(NotFoundException::new);
    }
}
