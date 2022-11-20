package ru.netology.daowithhibernate.repository;

import lombok.Data;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.entity.PersonsId;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Data
public class Repository {

    @PersistenceContext
    private EntityManager entityManager;

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

        for (Persons entity : listPerson) {
            entityManager.persist(entity);
        }
    }

    @Transactional
    public List<Persons> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Persons p where p.city = :city order by p.personsId.name");
        query.setParameter("city", city);
        return (List<Persons>) query.getResultList();
    }
}
