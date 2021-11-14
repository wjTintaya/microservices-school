package com.nttdata.repository;

import com.nttdata.model.Client;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {

    @Override
    public void connection(){
            System.out.println("Established connection");
    }

    @Override
    public List<Client> getAll() {
        List<Client> clients;
        clients = new ArrayList<>();
        clients.add(new Client(1, "Adrian Rodriguez Molano", "Av.Cuba 261 Lima", ClientType.PERSON.getValue()));
        clients.add(new Client(2, "Las Americas S.A.C", "Calle Primavera 154 Callao", ClientType.COMPANY.getValue()));
        clients.add(new Client(3, "La República S.A.C", "Av. Las Torres 248 Arequipa", ClientType.COMPANY.getValue()));
        clients.add(new Client(4, "Edgar Paixao Velez", "Av. Salaverry 845 Cusco", ClientType.PERSON.getValue()));
        clients.add(new Client(5, "German Serres Fonseca", "Av. España 784 Apurimac", ClientType.PERSON.getValue()));
        clients.add(new Client(6, "Hector Flores Paredes", "Av. Balta 415 Puno", ClientType.PERSON.getValue()));

        connection();
        return clients;
    }
}
