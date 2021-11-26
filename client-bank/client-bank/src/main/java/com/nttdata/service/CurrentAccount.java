package com.nttdata.service;

import com.nttdata.model.AccountMovement;
import com.nttdata.repository.AccountMovementType;
import com.nttdata.repository.Repository;
import com.nttdata.repository.RepositoryImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CurrentAccount implements Deposit, Withdrawal {

    private static final Double feeMaintenance = 25.00;
    private static final LocalDate maintenancePayday = LocalDate.parse("2021-01-01");

    private Repository repository;

    public CurrentAccount() {
        repository = new RepositoryImpl();
    }

    @Override
    public List<AccountMovement> getDepositsByAccountId(Integer idAccount) {

        return repository.findAllAccountMovements().get()
                .stream()
                .filter(accountMovement -> accountMovement.getAccountId().equals(idAccount) && accountMovement.getType() == AccountMovementType.DEPOSIT.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void setDeposit(Integer idAccount, Double amount) {

        AccountMovement deposit = AccountMovement
                .builder()
                .id(repository.lastAccountMovementId() + 1)
                .type(AccountMovementType.DEPOSIT.getValue())
                .amount(amount)
                .date(LocalDate.now())
                .accountId(idAccount)
                .build();
        repository.insertAccountMovement(deposit);
        System.out.println("Registered deposit");
    }

    @Override
    public List<AccountMovement> getWithdrawalsByAccountId(Integer idAccount) {

        return repository.findAllAccountMovements().get()
                .stream()
                .filter(accountMovement -> accountMovement.getAccountId().equals(idAccount) && accountMovement.getType() == AccountMovementType.WITHDRAWAL.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void setWithdrawal(Integer idAccount, Double amount) {

        AccountMovement deposit = AccountMovement
                .builder()
                .id(repository.lastAccountMovementId() + 1)
                .type(AccountMovementType.WITHDRAWAL.getValue())
                .amount(amount)
                .date(LocalDate.now())
                .accountId(idAccount)
                .build();
        repository.insertAccountMovement(deposit);
        System.out.println("Registered withdrawal");
    }

    private List<AccountMovement> getMaintenanceByAccountId(Integer idAccount) {

        return repository.findAllAccountMovements().get()
                .stream()
                .filter(accountMovement -> accountMovement.getAccountId().equals(idAccount) && accountMovement.getType() == AccountMovementType.MAINTENANCE.getValue())
                .collect(Collectors.toList());
    }

    private void validFeeMaintenance(Integer idAccount) {
        LocalDate getNow = LocalDate.now();
        if (getNow.getMonth().equals(maintenancePayday.getMonth()) && getNow.getDayOfMonth() == maintenancePayday.getDayOfMonth()) {
            AccountMovement maintenance = AccountMovement
                    .builder()
                    .id(repository.lastAccountMovementId() + 1)
                    .type(AccountMovementType.MAINTENANCE.getValue())
                    .amount(feeMaintenance)
                    .date(LocalDate.now())
                    .accountId(idAccount)
                    .build();
            repository.insertAccountMovement(maintenance);
            System.out.println("Registered maintenance");
        } else System.out.println("Maintenance is not paid");

    }

}
