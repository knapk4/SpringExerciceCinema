package fr.piga.cinemaspring.seances;

import fr.piga.cinemaspring.films.Film;
import fr.piga.cinemaspring.salles.Salle;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "seance")
public class Seance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "placesLibres")
    private Integer placesLibres;
    @Column(name = "prix")
    private float prix;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @ManyToOne
    @JoinColumn(name = "salle_id")
    private Salle salle;

}
