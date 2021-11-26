package com.nttdata.service;

import com.nttdata.model.AccountMovement;
import com.nttdata.repository.AccountMovementType;
import com.nttdata.repository.Repository;
import com.nttdata.repository.RepositoryImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class FixedTerm implements Deposit, Withdrawal{

    private static final int monthlyMovementsLimit = 1;
    private static final int dayOfTheMonth = 1;

    private Repository repository;

    public FixedTerm() {
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

        if (validMonthlyMovementsLimit(idAccount)) {
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
        } else System.out.println("Movement limit exceeded");
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

        if (validMonthlyMovementsLimit(idAccount)) {
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
        } else System.out.println("Movement limit exceeded");
    }

    private Boolean validMonthlyMovementsLimit(Integer idAccount) {
        LocalDate getNow = LocalDate.now();
        LocalDate movementDate = LocalDate.of(getNow.getYear(),getNow.getMonth(), dayOfTheMonth);
        Integer deposits =
                getDepositsByAccountId(idAccount)
                        .stream()
                        .filter(accountMovement -> accountMovement.getDate().equals(movementDate))
                        .collect(Collectors.toList())
                        .size();
        Integer withdrawals =
                getWithdrawalsByAccountId(idAccount)
                        .stream()
                        .filter(accountMovement -> accountMovement.getDate().equals(movementDate))
                        .collect(Collectors.toList())
                        .size();
        if ((deposits + withdrawals) < monthlyMovementsLimit && getNow.equals(movementDate)) return true;
        else return false;
    }

}
