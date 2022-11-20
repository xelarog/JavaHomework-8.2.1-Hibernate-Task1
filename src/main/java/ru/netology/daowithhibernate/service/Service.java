package ru.netology.daowithhibernate.service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.netology.daowithhibernate.entity.Persons;
import ru.netology.daowithhibernate.repository.Repository;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Service {
    private Repository repository;

    public List<Persons> getPersonsByCity(String city) {
        return repository.getPersonsByCity(city);
    }

}
