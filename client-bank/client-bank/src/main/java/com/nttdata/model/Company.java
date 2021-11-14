package com.nttdata.model;

import lombok.experimental.SuperBuilder;

public class Company extends Client{
    public Company(Integer id, String name, String direction, Integer type) {
        super(id, name, direction, type);
    }
}
