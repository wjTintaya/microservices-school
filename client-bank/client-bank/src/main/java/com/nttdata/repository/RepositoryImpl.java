package com.nttdata.repository;

import com.nttdata.model.Account;
import com.nttdata.model.AccountMovement;
import com.nttdata.model.Client;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepositoryImpl implements Repository {

    private List<Client> clientsList;
    private List<Account> accountList;
    private List<AccountMovement> accountMovementList;


    public RepositoryImpl() {
        generateClientsList();
        generateAccountsList();
        generateAccountMovementsList();
    }

    private void connection() {
        System.out.println("Established connection");
    }

    @Override
    public Optional<List<Client>> findAllClients() {
        connection();
        return Optional.of(clientsList);
    }

    @Override
    public Optional<List<Account>> findAllAccounts() {
        connection();
        return Optional.of(accountList);
    }

    @Override
    public Optional<List<AccountMovement>> findAllAccountMovements() {
        connection();
        return Optional.of(accountMovementList);
    }

    @Override
    public void insertAccountMovement(AccountMovement accountMovement) {
        accountMovementList.add(accountMovement);
    }

    @Override
    public Integer lastAccountMovementId() {
        Optional<Integer> idValue = accountMovementList
                .stream()
                .map(accountMovement -> accountMovement.getId())
                .reduce((Integer::max));
        if (idValue.isPresent()) return idValue.get();
        else return 0;
    }

    @Override
    public Optional<Account> findAccountById(Integer idAccount) {
        return accountList.stream()
                .filter(account -> account.getId().equals(idAccount))
                .findFirst();
    }

    private void generateClientsList() {

        clientsList = new ArrayList<>();
        clientsList.add(new Client(1, "Adrian Rodriguez Molano", "Av.Cuba 261 Lima", ClientType.PERSON.getValue()));
        clientsList.add(new Client(2, "Las Americas S.A.C", "Calle Primavera 154 Callao", ClientType.COMPANY.getValue()));
        clientsList.add(new Client(3, "La República S.A.C", "Av. Las Torres 248 Arequipa", ClientType.COMPANY.getValue()));
        clientsList.add(new Client(4, "Edgar Paixao Velez", "Av. Salaverry 845 Cusco", ClientType.PERSON.getValue()));
        clientsList.add(new Client(5, "German Serres Fonseca", "Av. España 784 Apurimac", ClientType.PERSON.getValue()));
        clientsList.add(new Client(6, "Hector Flores Paredes", "Av. Balta 415 Puno", ClientType.PERSON.getValue()));
    }

    private void generateAccountsList() {

        accountList = new ArrayList<>();
        accountList.add(new Account(1, "123-456-789", BankAccountType.SAVINGS_ACCOUNT.getValue(), 0.00, 5, 100.00, 1));
        accountList.add(new Account(2, "123-456-790", BankAccountType.SAVINGS_ACCOUNT.getValue(), 0.00, 5, 500.00, 4));
        accountList.add(new Account(3, "123-456-790", BankAccountType.CURRENT_ACCOUNT.getValue(), 0.00, 5, 500.00, 2));
    }

    private void generateAccountMovementsList() {

        accountMovementList = new ArrayList<>();
        accountMovementList.add(new AccountMovement(1, AccountMovementType.DEPOSIT.getValue(), 150.00, LocalDate.parse("2021-10-10"), 1));
        accountMovementList.add(new AccountMovement(2, AccountMovementType.WITHDRAWAL.getValue(), 50.00, LocalDate.parse("2021-10-20"), 1));
        accountMovementList.add(new AccountMovement(3, AccountMovementType.WITHDRAWAL.getValue(), 50.00, LocalDate.parse("2021-10-20"), 3));
    }
}
