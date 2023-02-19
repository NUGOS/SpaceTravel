package ua.goit.spacetravel;

import ua.goit.spacetravel.model.Client;
import ua.goit.spacetravel.model.Planet;
import ua.goit.spacetravel.model.Ticket;
import ua.goit.spacetravel.service.ClientCrudService;
import ua.goit.spacetravel.service.PlanetCrudService;
import ua.goit.spacetravel.service.TicketCrudService;

import java.time.LocalDateTime;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        ClientCrudService clientService = new ClientCrudService();
        PlanetCrudService planetService = new PlanetCrudService();
        TicketCrudService ticketCrudService = new TicketCrudService();

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
        System.out.println("Видалили клієнта: " + client);
        clientService.delete(client);

        // Пошук всіх планет
        List<Planet> planets = planetService.getAll();
        for (Planet planet : planets) {
            System.out.println("Знайшли всі планети: " + planet.toString());
        }

        // Пошук за id
        System.out.println("Пошук за id планети: " + planetService.getById("VEN"));

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
        System.out.println("Оновили планету: " + planetService.getById("OMG"));

        // Видаляємо планету
        planetService.delete("OMG");

        //Беремо з бази клієнтів та планети
        Client client1 = clientService.getById(3L);
        Client client2 = clientService.getById(5L);
        Planet planet1 = planetService.getById("VEN");
        Planet planet2 = planetService.getById("MARS");

        // Створюємо квиток 1
        Ticket ticket1 = new Ticket();
        ticket1.setCreatedAt(LocalDateTime.now());
        ticket1.setClient(client1);
        ticket1.setFromPlanet(planet1);
        ticket1.setToPlanet(planet2);

        // Створюємо квиток 2
        Ticket ticket2 = new Ticket();
        ticket2.setCreatedAt(LocalDateTime.now());
        ticket2.setClient(client2);
        ticket2.setFromPlanet(planet2);
        ticket2.setToPlanet(planet1);

        // Зберігаємо квитки
        ticketCrudService.create(ticket1);
        ticketCrudService.create(ticket2);

        // Знаходимо всі квитки
        System.out.println("Знаходимо всі квитки: " + ticketCrudService.getAll());

        // Оновлюємо квиток
        System.out.println(ticketCrudService.getById(1L));

        // Видаляємо квиток
        System.out.println("Видаляємо квиток: " + ticket2);
        ticketCrudService.delete(ticket2);
    }
}

