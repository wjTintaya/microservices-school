package com.nttdata.service;

import com.nttdata.model.AccountMovement;
import com.nttdata.repository.AccountMovementType;
import com.nttdata.repository.Repository;
import com.nttdata.repository.RepositoryImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class Credit implements Payment{

    private Repository repository;

    public Credit() {
        repository = new RepositoryImpl();
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
}
