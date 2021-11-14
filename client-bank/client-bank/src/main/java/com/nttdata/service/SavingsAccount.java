package com.nttdata.service;

import com.nttdata.model.Account;
import lombok.experimental.SuperBuilder;

public class SavingsAccount extends Account implements Deposit, Withdrawal {
    public SavingsAccount(Integer id, String accountNumber, String description, Double maintenanceFee, Integer monthlyMovement, Double balance, Integer clientId) {
        super(id, accountNumber, description, maintenanceFee, monthlyMovement, balance, clientId);
    }
    //
}
