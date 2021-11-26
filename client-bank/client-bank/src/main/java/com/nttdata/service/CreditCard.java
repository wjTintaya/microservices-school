package com.nttdata.service;

import com.nttdata.model.Account;
import com.nttdata.model.AccountMovement;
import com.nttdata.repository.AccountMovementType;
import com.nttdata.repository.Repository;
import com.nttdata.repository.RepositoryImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class CreditCard implements Purchase, Payment {

    private Repository repository;

    public CreditCard() {
        repository = new RepositoryImpl();
    }

    @Override
    public List<AccountMovement> getPurchasesByAccountId(Integer idAccount) {

        return repository.findAllAccountMovements().get()
                .stream()
                .filter(accountMovement -> accountMovement.getAccountId().equals(idAccount) && accountMovement.getType() == AccountMovementType.PURCHASE.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void setPurchase(Integer idAccount, Double amount) {

        if (validCreditLimit(idAccount, amount)) {
            AccountMovement purchase= AccountMovement
                    .builder()
                    .id(repository.lastAccountMovementId() + 1)
                    .type(AccountMovementType.PURCHASE.getValue())
                    .amount(amount)
                    .date(LocalDate.now())
                    .accountId(idAccount)
                    .build();
            repository.insertAccountMovement(purchase);
            System.out.println("Registered purchase");
        } else System.out.println("Credit limit exceeded");
    }

    @Override
    public List<AccountMovement> getPaymentsByAccountId(Integer idAccount) {

        return repository.findAllAccountMovements().get()
                .stream()
                .filter(accountMovement -> accountMovement.getAccountId().equals(idAccount) && accountMovement.getType() == AccountMovementType.PAYMENT.getValue())
                .collect(Collectors.toList());
    }

    @Override
    public void setPayment(Integer idAccount, Double amount) {

        AccountMovement payment = AccountMovement
                .builder()
                .id(repository.lastAccountMovementId() + 1)
                .type(AccountMovementType.PAYMENT.getValue())
                .amount(amount)
                .date(LocalDate.now())
                .accountId(idAccount)
                .build();
        repository.insertAccountMovement(payment);
        System.out.println("Registered payment");
    }

    private Boolean validCreditLimit(Integer idAccount, Double amount) {

        Account account = repository.findAccountById(idAccount).get();
        Double balance = account.getBalance() +
                getPaymentsByAccountId(idAccount)
                        .stream()
                        .map(accountMovement -> accountMovement.getAmount())
                        .reduce(Double::sum).get() +
                getPurchasesByAccountId(idAccount)
                        .stream()
                        .map(accountMovement -> accountMovement.getAmount())
                        .reduce(Double::sum).get();

        if (balance >= amount) return true;
        else return false;
    }

}
