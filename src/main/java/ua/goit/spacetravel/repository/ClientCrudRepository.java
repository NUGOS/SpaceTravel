package ua.goit.spacetravel.repository;

import ua.goit.spacetravel.model.Client;

import java.util.List;

public interface ClientCrudRepository {

    Client getById(Long id);
    List<Client> getAll();
    long create(Client client);
    void update(Client client);
    void delete(Client client);
}
