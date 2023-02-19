package ua.goit.spacetravel.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.goit.spacetravel.model.Client;
import ua.goit.spacetravel.model.Planet;
import ua.goit.spacetravel.model.Ticket;
import ua.goit.spacetravel.repository.ClientCrudRepository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class ClientCrudService implements ClientCrudRepository {

    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Client.class)
            .addAnnotatedClass(Ticket.class)
            .addAnnotatedClass(Planet.class)
            .buildSessionFactory();

    public Client getById(Long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Client.class, id);
        }
    }

    public List<Client> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Client> query = session.getCriteriaBuilder().createQuery(Client.class);
            query.from(Client.class);
            return session.createQuery(query).getResultList();
        }
    }

    public long create(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(client);
            transaction.commit();
        }
        return client.getId();
    }

    public void update(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(client);
            transaction.commit();
        }
    }

    public void delete(Client client) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(client);
            transaction.commit();
        }
    }
}
