package com.nttdata.service;

import com.nttdata.model.AccountMovement;

import java.util.List;

public interface Withdrawal {

    List<AccountMovement> getWithdrawalsByAccountId(Integer idAccount);

    void setWithdrawal(Integer idAccount, Double amount);

}
