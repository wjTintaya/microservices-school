package com.nttdata.model;

import lombok.experimental.SuperBuilder;

public class Person extends Client{
    public Person(Integer id, String name, String direction, Integer type) {
        super(id, name, direction, type);
    }
}
