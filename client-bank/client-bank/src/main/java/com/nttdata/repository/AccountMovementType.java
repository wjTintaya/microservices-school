package com.nttdata.repository;

public enum AccountMovementType {
    DEPOSIT (1),
    WITHDRAWAL (2);

    private int value;

    AccountMovementType(int value) {
        this.value = value;
    }
    public int getValue(){
        return value;
    }
}
