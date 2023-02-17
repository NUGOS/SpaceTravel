package ua.goit.spacetravel.repository;

import ua.goit.spacetravel.model.Planet;

import java.util.List;

public interface PlanetCrudRepository {

    Planet getById(String id);
    List<Planet> getAll();
    void create(Planet planet);
    void update(String id);
    void delete(String id);
}
