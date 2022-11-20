package ru.netology.daowithhibernate.repository;

import lombok.Data;
import ru.netology.daowithhibernate.entity.Persons;
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
    public List<Persons> getPersonsByCity(String city) {
        Query query = entityManager.createQuery("select p from Persons p where p.city = :city order by p.personsId.name");
        query.setParameter("city", city);
        return (List<Persons>) query.getResultList();
    }
}
