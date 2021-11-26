package com.nttdata.repository;

public enum CreditType {
    PERSONAL(4),
    BUSINESS(5),
    CREDIT_CARD(6);

    private int value;

    CreditType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
