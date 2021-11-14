package com.nttdata.repository;

import com.nttdata.model.Client;

import java.util.List;

public interface ClientRepository {
    void connection() throws Exception;
    List<Client> getAll();
}
