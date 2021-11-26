package com.nttdata.service;

import com.nttdata.model.AccountMovement;

import java.util.List;

public interface Deposit {

    List<AccountMovement> getDepositsByAccountId(Integer idAccount);

    void setDeposit(Integer idAccount, Double amount);
}
