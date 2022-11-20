package ru.netology.daowithhibernate.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.io.Serializable;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Embeddable
public class PersonsId implements Serializable {
    private String name;
    private String surname;
    private Integer age;
}
