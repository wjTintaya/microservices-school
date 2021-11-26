package com.nttdata.repository;

public enum BankAccountType {
    SAVINGS_ACCOUNT(1),
    CURRENT_ACCOUNT(2),
    FIXED_TERM(3);

    private int value;

    BankAccountType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

}
