package ru.netology.daowithhibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.entity.PersonsId;

import java.util.List;
import java.util.Optional;

public interface PersonsRepository extends JpaRepository<Persons, PersonsId> {

    List<Persons> findByCity(String city);

    List<Persons> findByPersonsIdAgeLessThanOrderByPersonsIdAge(Integer age);

    Optional<Persons> findByPersonsIdNameAndPersonsIdSurname(String name, String surname);

}
