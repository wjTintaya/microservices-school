package com.nttdata.repository;

import com.nttdata.model.Account;
import com.nttdata.model.AccountMovement;
import com.nttdata.model.Client;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class RepositoryImpl implements Repository {

    @Override
    public void connection() {
        System.out.println("Established connection");
    }

    @Override
    public Stream<Client> getAllClients() {
        List<Client> clients;
        clients = new ArrayList<>();
        clients.add(new Client(1, "Adrian Rodriguez Molano", "Av.Cuba 261 Lima", ClientType.PERSON.getValue()));
        clients.add(new Client(2, "Las Americas S.A.C", "Calle Primavera 154 Callao", ClientType.COMPANY.getValue()));
        clients.add(new Client(3, "La República S.A.C", "Av. Las Torres 248 Arequipa", ClientType.COMPANY.getValue()));
        clients.add(new Client(4, "Edgar Paixao Velez", "Av. Salaverry 845 Cusco", ClientType.PERSON.getValue()));
        clients.add(new Client(5, "German Serres Fonseca", "Av. España 784 Apurimac", ClientType.PERSON.getValue()));
        clients.add(new Client(6, "Hector Flores Paredes", "Av. Balta 415 Puno", ClientType.PERSON.getValue()));
        connection();
        return clients.stream();
    }

    @Override
    public Stream<Account> getAllAccounts() {
        List<Account> accounts;
        accounts = new ArrayList<>();
        accounts.add(new Account(1, "123-456-789","Cuenta de ahorro", 0.00, 5, 100.00, 1));
        accounts.add(new Account(2, "123-456-790","Cuenta de ahorro", 0.00, 5, 500.00, 4));
        connection();
        return accounts.stream();
    }

    @Override
    public Stream<AccountMovement> getAllAccountMovements() {
        List<AccountMovement> accountMovements;
        accountMovements = new ArrayList<>();
        accountMovements.add(new AccountMovement(1, AccountMovementType.DEPOSIT.getValue(), 150.00, new Date(2021, 1, 10), 1));
        accountMovements.add(new AccountMovement(2, AccountMovementType.WITHDRAWAL.getValue(), 50.00, new Date(2021, 1, 20), 1));
        connection();
        return accountMovements.stream();
    }

    @Override
    public Optional<Client> geClientById(Integer id) {
        return getAllClients().
                filter(client -> client.getId().equals(id))
                .findFirst();
    }

    @Override
    public Stream<Account> getAccountsByClient(Integer id) {
        return getAllAccounts()
                .filter(account -> account.getClientId().equals(id));
    }

    @Override
    public Optional<Account> getAccountById(Integer id) {
        return getAllAccounts()
                .filter(account -> account.getId().equals(id))
                .findFirst();
    }

    @Override
    public Stream<AccountMovement> getAccountMovementsByAccount(Integer id) {
        return getAllAccountMovements()
                .filter(accountMovement -> accountMovement.getAccountId().equals(id));
    }

    @Override
    public Optional<AccountMovement> getAccountMovementById(Integer id) {
        return getAllAccountMovements()
                .filter(accountMovement -> accountMovement.getId().equals(id))
                .findFirst();
    }
}
