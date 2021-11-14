package com.nttdata.service;

import com.nttdata.model.Account;
import com.nttdata.model.AccountMovement;

public class SavingsAccount extends Account implements IDeposit, IWithdrawal {

    private static final int monthlyMovementsLimit = 5;
    private static final Double zeroMaintenance = 0.00;

    public SavingsAccount(Integer id, String accountNumber, String description, Double maintenanceFee, Integer monthlyMovement, Double balance, Integer clientId) {
        super(id, accountNumber, description, maintenanceFee, monthlyMovement, balance, clientId);
    }

    public Double getMaintenanceFee(){
        return zeroMaintenance;
    }

    @Override
    public AccountMovement getDeposit(Integer idAccount) {
        return null;
    }

    @Override
    public void setDeposit(AccountMovement deposit) {

    }

}
