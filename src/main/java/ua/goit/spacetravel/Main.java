package ua.goit.spacetravel;

import ua.goit.spacetravel.model.Client;
import ua.goit.spacetravel.model.Planet;
import ua.goit.spacetravel.service.ClientCrudService;
import ua.goit.spacetravel.service.PlanetCrudService;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();

        // Пошук всіх клієнтів
        List<Client> clients = clientService.getAll();
        for (Client client : clients) {
            System.out.println(client.toString());
        }
        // Пошук за id
        System.out.println("Знаходимо клієнта за id=1: " + clientService.getById(1L));
        // Створюєм нового клієнта
        Client client = new Client("Vaasya");
        clientService.create(client);
        System.out.println("Створили клієнта: " + client);
        // Оновлюємо Клієна
        client.setName("Valera");
        clientService.update(client);
        System.out.println("Оновили імʼя клієнта: " + client);
        //Видаляємо Клієнта
        clientService.delete(client);

        // Пошук всіх планет
        List<Planet> planets = planetService.getAll();
        for (Planet planet : planets) {
            System.out.println(planet.toString());
        }
        // Пошук за id
        System.out.println(planetService.getById("VEN"));
        // Створюєм нову планету
        Planet planet = new Planet();
        planet.setId("OMG");
        planet.setName("Earth");
        planetService.create(planet);
        // Оновлюємо планету
        Planet planetUpdate = planetService.getById("OMG");
        String idPlanet = planetUpdate.getId();
        planetUpdate.setName("Mersi");
        planetService.update(idPlanet);
        System.out.println(planetService.getById("OMG"));
        // Видаляємо планету
        planetService.delete("OMG");
    }
}

