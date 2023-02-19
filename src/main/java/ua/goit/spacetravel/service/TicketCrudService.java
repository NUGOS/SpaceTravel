package ua.goit.spacetravel.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.goit.spacetravel.model.Client;
import ua.goit.spacetravel.model.Planet;
import ua.goit.spacetravel.model.Ticket;
import ua.goit.spacetravel.repository.TicketCrudRepository;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TicketCrudService implements TicketCrudRepository {

    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Client.class)
            .addAnnotatedClass(Planet.class)
            .addAnnotatedClass(Ticket.class)
            .buildSessionFactory();

    @Override
    public Ticket getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Ticket.class, id);
        }
    }

    @Override
    public List<Ticket> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Ticket> query = session.getCriteriaBuilder().createQuery(Ticket.class);
            query.from(Ticket.class);
            return session.createQuery(query).getResultList();
        }
    }

    @Override
    public Long create(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            if (isClientExist(ticket.getClient()) && isPlanetExist(ticket.getFromPlanet()) && isPlanetExist(ticket.getToPlanet())) {
                session.save(ticket);
                transaction.commit();
                return ticket.getId();
            } else {
                transaction.rollback();
                throw new IllegalArgumentException("Invalid ticket data. Client or planet does not exist.");
            }
        }
    }

    @Override
    public Long update(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            if (isClientExist(ticket.getClient()) && isPlanetExist(ticket.getFromPlanet()) && isPlanetExist(ticket.getToPlanet())) {
                session.update(ticket);
                transaction.commit();
                return ticket.getId();
            } else {
                transaction.rollback();
                throw new IllegalArgumentException("Invalid ticket data. Client or planet does not exist.");
            }
        }
    }

    @Override
    public void delete(Ticket ticket) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(ticket);
            transaction.commit();
        }
    }

    public boolean isClientExist(Client client) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Client> query = session.getCriteriaBuilder().createQuery(Client.class);
            Root<Client> root = query.from(Client.class);
            query.select(root).where(session.getCriteriaBuilder().equal(root.get("id"), client.getId()));
            return !session.createQuery(query).getResultList().isEmpty();
        }
    }

    public boolean isPlanetExist(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Planet> query = session.getCriteriaBuilder().createQuery(Planet.class);
            Root<Planet> root = query.from(Planet.class);
            query.select(root).where(session.getCriteriaBuilder().equal(root.get("id"), planet.getId()));
            return !session.createQuery(query).getResultList().isEmpty();
        }
    }
}
