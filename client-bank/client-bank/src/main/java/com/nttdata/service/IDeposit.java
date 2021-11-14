package com.nttdata.service;

import com.nttdata.model.AccountMovement;

public interface IDeposit {
    AccountMovement getDeposit(Integer idAccount);
    void setDeposit(AccountMovement deposit);
}
