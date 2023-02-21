import org.junit.jupiter.api.Test;
import ua.goit.spacetravel.model.Client;
import ua.goit.spacetravel.model.Planet;
import ua.goit.spacetravel.model.Ticket;
import ua.goit.spacetravel.service.ClientCrudService;
import ua.goit.spacetravel.service.TicketCrudService;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TicketCrudServiceTest {
    ClientCrudService clientCrudService = new ClientCrudService();
    TicketCrudService ticketCrudService = new TicketCrudService();

    @Test
    void testCreateTicketWithInvalidData(){
        // Створюємо клієнта та планету
        Client client1 = clientCrudService.getById(1L);
        Planet planet1 = new Planet("MARS", "Mars");
        Planet planet2 = new Planet("VEN", "Venus");

        // Створюємо квиток з неіснуючою планетою
        Ticket ticket1 = new Ticket();
        ticket1.setCreatedAt(LocalDateTime.now());
        ticket1.setClientId(client1);
        ticket1.setFromPlanetId(planet1);
        ticket1.setToPlanetId(new Planet("UNK", "Unknown"));

        // Створюємо квиток з неіснуючим клієнтом
        Ticket ticket2 = new Ticket();
        ticket2.setCreatedAt(LocalDateTime.now());
        ticket2.setClientId(new Client("Unknown"));
        ticket2.setFromPlanetId(planet1);
        ticket2.setToPlanetId(planet2);

        // перевіряємо, що неможливо зберегти квиток для неіснуючої або null планети
        assertThrows(IllegalArgumentException.class, () -> ticketCrudService.create(ticket1));

        // перевіряємо, що неможливо зберегти квиток для неіснуючого або null клієнта
        assertThrows(IllegalArgumentException.class, () -> ticketCrudService.create(ticket2));

    }
}
