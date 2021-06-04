package org.example.controller;

import org.example.entity.Client;
import org.example.repository.JRepo;
import org.example.repository.impl.ClientRepositoryImpl;

import java.sql.SQLException;
import java.util.List;

public class ClientController {
    private JRepo jRepo = new ClientRepositoryImpl();

    public Client getClientById(Long id) throws SQLException {
        return (Client) jRepo.getById(id);
    }

    public Client editClient(Client client) throws SQLException {
        return (Client) jRepo.update(client);
    }

    public List<Client> getAllClients() throws SQLException {
        return jRepo.getAll();
    }

    public void saveClient(Client client) throws SQLException {
        jRepo.add(client);
    }

    public void deleteClient(Long id) throws SQLException {
        jRepo.remove(id);
    }

}
