package com.nttdata.repository;

public enum ClientType {
    PERSON (1),
    COMPANY (2);

    private int value;

    ClientType(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
