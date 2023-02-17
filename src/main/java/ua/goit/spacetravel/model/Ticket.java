package ua.goit.spacetravel.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id", nullable = false)
    @ToString.Exclude
    private Client clientId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "from_planet_id", nullable = false)
    @ToString.Exclude
    private Planet fromPlanetId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "to_planet_id", nullable = false)
    @ToString.Exclude
    private Planet toPlanetId;
}

