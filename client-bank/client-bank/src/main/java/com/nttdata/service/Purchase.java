package com.nttdata.service;

import com.nttdata.model.AccountMovement;

import java.util.List;

public interface Purchase {

    List<AccountMovement> getPurchasesByAccountId(Integer idAccount);

    void setPurchase(Integer idAccount, Double amount);

}
