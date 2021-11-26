package com.nttdata.service;

import com.nttdata.model.Account;
import com.nttdata.model.Client;
import com.nttdata.repository.BankAccountType;
import com.nttdata.repository.CreditType;

import java.util.List;

public interface ClientService {

    void verifyNumberOfBankAccounts(Client client, BankAccountType bankAccountType);
    void createBankAccount(Client client, Account account);
    void verifyNumberOfCredits(Client client, CreditType creditType);
    void getClientsList();

}
