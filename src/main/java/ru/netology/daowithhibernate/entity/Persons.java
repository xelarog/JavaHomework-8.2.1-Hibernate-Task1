package ru.netology.daowithhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Persons {


    @Id
    private PersonsId personsId;

    private String phoneNumber;

    @Column(name = "city_of_living")
    private String city;

}
