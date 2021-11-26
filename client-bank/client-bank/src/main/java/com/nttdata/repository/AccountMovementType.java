package com.nttdata.repository;

public enum AccountMovementType {
    DEPOSIT(1),
    WITHDRAWAL(2),
    MAINTENANCE(3),
    PAYMENT(4),
    PURCHASE(5);

    private int value;

    AccountMovementType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
