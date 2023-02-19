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

        //Беремо з бази клієнтів та планети
        Client client1 = clientService.getById(3L);
        Client client2 = clientService.getById(5L);
        Planet planet1 = planetService.getById("VEN");
        Planet planet2 = planetService.getById("MARS");
        // Створюємо квиток 1
        Ticket ticket1 = new Ticket();
        ticket1.setCreatedAt(LocalDateTime.now());
        ticket1.setClientId(client1);
        ticket1.setFromPlanetId(planet1);
        ticket1.setToPlanetId(planet2);
        //Створюємо квиток 2
        Ticket ticket2 = new Ticket();
        ticket2.setCreatedAt(LocalDateTime.now());
        ticket2.setClientId(client2);
        ticket2.setFromPlanetId(planet2);
        ticket2.setToPlanetId(planet1);

        // Створюю квиток з неіснуючою планетою
        Ticket ticket3 = new Ticket();
        ticket3.setCreatedAt(LocalDateTime.now());
        ticket3.setClientId(client1);
        ticket3.setFromPlanetId(new Planet("UNK", "Unknown"));
        ticket3.setToPlanetId(planet2);

        // Створюю квиток з неіснуючим клієнтом
        Ticket ticket4 = new Ticket();
        ticket4.setCreatedAt(LocalDateTime.now());
        ticket4.setClientId(new Client("Unknown"));
        ticket4.setFromPlanetId(planet1);
        ticket4.setToPlanetId(planet2);

        // зберігаємо квитки
        ticketCrudService.create(ticket1);
        ticketCrudService.create(ticket2);


    }
}

