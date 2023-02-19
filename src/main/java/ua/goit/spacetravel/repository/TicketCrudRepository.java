package ua.goit.spacetravel.repository;

import ua.goit.spacetravel.model.Ticket;

import java.util.List;

public interface TicketCrudRepository {
    Ticket getById(Long id);
    List<Ticket> getAll();
    Long create(Ticket ticket);
    Long update(Ticket ticket);
    void delete(Ticket ticket);
}
