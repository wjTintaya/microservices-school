package com.nttdata.service;

import com.nttdata.model.Account;
import com.nttdata.model.Client;
import com.nttdata.repository.*;

import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {

    private Repository repository;

    public ClientServiceImpl() {
        repository = new RepositoryImpl();
    }

    @Override
    public void verifyNumberOfBankAccounts(Client client, BankAccountType bankAccountType) {

        if (client.getType().equals(ClientType.PERSON.getValue())) {
            System.out.println(verifyPersonBankAccounts(client.getId()));
        } else if (client.getType().equals(ClientType.COMPANY.getValue())) {
            System.out.println(verifyCompanyBankAccounts(bankAccountType));
        } else {
            System.out.println("Unidentified client type");
        }
    }

    @Override
    public void createBankAccount(Client client, Account account) {

    }

    @Override
    public void verifyNumberOfCredits(Client client, CreditType creditType) {

        if (client.getType().equals(ClientType.PERSON.getValue())) {
            System.out.println(verifyPersonCredit(client.getId(), creditType));
        } else if (client.getType().equals(ClientType.COMPANY.getValue())) {
            System.out.println(verifyCompanyCredit(creditType));
        } else {
            System.out.println("Unidentified client type");
        }
    }

    @Override
    public void getClientsList() {
        repository.findAllClients().get()
                .stream()
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }

    private String verifyPersonBankAccounts(Integer idClient) {

        Boolean hasAccounts =
                !repository.findAllAccounts().get()
                        .stream()
                        .filter(account -> account.getClientId().equals(idClient))
                        .collect(Collectors.toList())
                        .isEmpty();
        if (hasAccounts) return "Can't have more accounts";
        else return "Can create account";
    }

    private String verifyCompanyBankAccounts(BankAccountType bankAccountType) {

        Boolean isCurrentAccount = bankAccountType.equals(BankAccountType.CURRENT_ACCOUNT);
        if (isCurrentAccount) return "Can create account";
        else return "Can't create account";
    }

    private String verifyPersonCredit(Integer idClient, CreditType creditType) {

        Boolean isCreditCard = (creditType.equals(CreditType.CREDIT_CARD));
        Boolean isPersonalCreditPossible =
                repository.findAllAccounts().get()
                        .stream()
                        .filter(account -> account.getClientId().equals(idClient) && account.getAccountType().equals(CreditType.PERSONAL.getValue()))
                        .collect(Collectors.toList())
                        .isEmpty();
        if (isCreditCard || isPersonalCreditPossible) return "Can create credit";
        else return "Can't create credit";
    }

    private String verifyCompanyCredit(CreditType creditType) {

        Boolean isCreditAccountValid = (creditType.equals(CreditType.BUSINESS) || creditType.equals(CreditType.CREDIT_CARD));
        if (isCreditAccountValid) return "Can create credit";
        else return "Can't create credit";
    }
}
