CREATE TABLE PERSONS
(
    name           varchar,
    surname        varchar,
    age            int,
    phone_number   varchar NOT NULL,
    city_of_living varchar NOT NULL,
    PRIMARY KEY (name, surname, age)
);

