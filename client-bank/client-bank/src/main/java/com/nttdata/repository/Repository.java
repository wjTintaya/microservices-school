package com.nttdata.repository;

import com.nttdata.model.Account;
import com.nttdata.model.AccountMovement;
import com.nttdata.model.Client;

import java.util.Optional;
import java.util.stream.Stream;

public interface Repository {
    void connection();
    Stream<Client> getAllClients();
    Stream<Account> getAllAccounts();
    Stream<AccountMovement> getAllAccountMovements();

    Optional<Client> geClientById(Integer id);

    Stream<Account> getAccountsByClient(Integer id);
    Optional<Account> getAccountById(Integer id);

    Stream<AccountMovement> getAccountMovementsByAccount(Integer id);
    Optional<AccountMovement> getAccountMovementById(Integer id);
}
