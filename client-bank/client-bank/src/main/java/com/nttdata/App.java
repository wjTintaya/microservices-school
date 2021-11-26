package com.nttdata;

import com.nttdata.repository.ClientType;
import com.nttdata.service.ClientService;
import com.nttdata.service.ClientServiceImpl;
import com.nttdata.service.CurrentAccount;
import com.nttdata.service.Deposit;

import java.util.stream.Collectors;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ClientService clientService = new ClientServiceImpl();
        CurrentAccount currentAccount = new CurrentAccount();

        clientService.getClientsList();
    }
}
