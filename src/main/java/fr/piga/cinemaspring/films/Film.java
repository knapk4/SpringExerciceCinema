package fr.piga.cinemaspring.films;

import fr.piga.cinemaspring.acteurs.Acteur;
import fr.piga.cinemaspring.realisateurs.Realisateur;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Film entity class for the cinema project with JPA annotations
 * @Entity - specifies that the class is an entity and is mapped to a database table.
 * @Table - specifies the name of the database table to be used for mapping.
 * @Id - specifies the primary key of an entity.
 * @GeneratedValue - provides the generation strategy specification for the primary key values.
 * @ManyToMany - specifies many-to-many relationship between two entities.
 * @NoArgsConstructor - provides a no-arg constructor that is public and has no code.
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "film")
public class Film {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "titre", nullable = false)
    private String titre;

    @Column(name = "dateSortie", nullable = false)
    private LocalDate dateSortie;

    @Column(name = "duree", nullable = false)
    private String duree;

    @Column(name = "resume", nullable = false)
    private String resume;

    /**
     * Many to many relationship between Film and Acteur
     * @ManyToMany - specifies many-to-many relationship between two entities.
     * @JoinTable - specifies the join / target table for a many-to-many association.
     * @JoinColumn - specifies the join column for a many-to-many association.
     * @InverseJoinColumn - specifies the join column for the inverse side of a many-to-many association.
     */
    @ManyToMany
    @JoinTable(name = "film_acteur",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id")
    )
    private List<Acteur> acteurs = new ArrayList<>();

    @ManyToMany(mappedBy = "films")
    private List<Realisateur> realisateurs = new ArrayList<>();
}
