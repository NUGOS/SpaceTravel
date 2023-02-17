package ua.goit.spacetravel.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import ua.goit.spacetravel.model.Planet;
import ua.goit.spacetravel.repository.PlanetCrudRepository;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
public class PlanetCrudService implements PlanetCrudRepository {

    SessionFactory sessionFactory = new Configuration()
            .addAnnotatedClass(Planet.class)
            .buildSessionFactory();

    public Planet getById(String id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Planet.class, id);
        }
    }

    public List<Planet> getAll() {
        try (Session session = sessionFactory.openSession()) {
            CriteriaQuery<Planet> query = session.getCriteriaBuilder().createQuery(Planet.class);
            query.from(Planet.class);
            return session.createQuery(query).getResultList();
        }
    }

    public void create(Planet planet) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(planet);
            transaction.commit();
        }
    }

    public void update(String id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = getById(id);
            session.update(planet);
            transaction.commit();
        }
    }

    public void delete(String id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            Planet planet = session.get(Planet.class, id);
            session.delete(planet);
            transaction.commit();
        }
    }
}
