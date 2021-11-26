package com.nttdata.service;

import com.nttdata.model.AccountMovement;

import java.util.List;

public interface Payment {

    List<AccountMovement> getPaymentsByAccountId(Integer idAccount);

    void setPayment(Integer idAccount, Double amount);

}
