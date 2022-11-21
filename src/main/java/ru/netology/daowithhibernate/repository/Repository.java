package ru.netology.daowithhibernate.repository;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.entity.PersonsId;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Component
@AllArgsConstructor
@Data
public class Repository {

    private PersonsRepository personsRepository;

    @Transactional
    public void addPersons() {
        List<Persons> listPerson = List.of(
                new Persons(new PersonsId("Alex", "Petrov", 23), "21321325", "Moscow"),
                new Persons(new PersonsId("Ivan", "Sidorov", 40), "4645645634", "Tver"),
                new Persons(new PersonsId("Evgeny", "Romanov", 24), "787875", "Rostov"),
                new Persons(new PersonsId("Olga", "Simonova", 33), "45456456", "Moscow"),
                new Persons(new PersonsId("Irina", "Frolova", 38), "8888887777", "Smolensk"),
                new Persons(new PersonsId("Roman", "Kozlov", 15), "33345453458", "Moscow")
        );

        personsRepository.saveAll(listPerson);
    }

    @Transactional
    public List<Persons> getPersonsByCity(String city) {
        return personsRepository.findByCity(city);
    }

    public List<Persons> getPersonsByAgeLessThan(int age) {
        return personsRepository.findByPersonsIdAgeLessThanOrderByPersonsIdAge(age);
    }

    public Optional<Persons> getPersonByNameAndSurname(String name, String surname) {
        return personsRepository.findByPersonsIdNameAndPersonsIdSurname(name, surname);
    }


}
