package fr.piga.cinemaspring.tickets;

import fr.piga.cinemaspring.seances.Seance;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(name = "nomClient",nullable = false)
    String nomClient;
    @Column(name = "nbPlaces",nullable = false)
    Integer nbPlaces;

    @ManyToOne
    @JoinColumn(name = "seance_id")
    private Seance seance;
}
