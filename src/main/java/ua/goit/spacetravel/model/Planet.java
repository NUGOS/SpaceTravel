package ua.goit.spacetravel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "planet")
@Data
public class Planet {
    @Id
    @Column(length = 3, nullable = false)
    private String id;

    @Column(length = 500, nullable = false)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fromPlanet")
    private Set<Ticket> fromTickets;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "toPlanet")
    private Set<Ticket> toTickets;

    public Planet(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public Planet() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Ticket> getFromTickets() {
        return fromTickets;
    }

    public void setFromTickets(Set<Ticket> fromTickets) {
        this.fromTickets = fromTickets;
    }

    public Set<Ticket> getToTickets() {
        return toTickets;
    }

    public void setToTickets(Set<Ticket> toTickets) {
        this.toTickets = toTickets;
    }
}

