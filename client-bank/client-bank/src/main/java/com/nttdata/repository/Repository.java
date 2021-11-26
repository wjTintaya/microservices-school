package com.nttdata.repository;

import com.nttdata.model.Account;
import com.nttdata.model.AccountMovement;
import com.nttdata.model.Client;

import java.util.List;
import java.util.Optional;

public interface Repository {

    Optional<List<Client>> findAllClients();

    Optional<List<Account>> findAllAccounts();

    Optional<List<AccountMovement>> findAllAccountMovements();

    void insertAccountMovement(AccountMovement deposit);

    Integer lastAccountMovementId();

    Optional<Account> findAccountById(Integer idAccount);

}
