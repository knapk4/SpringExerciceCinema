package fr.piga.cinemaspring.acteurs;

import fr.piga.cinemaspring.films.Film;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by piga on 10/12/2016.
 * Acteur entity class for the cinema project with JPA annotations
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
@Table(name = "acteur")

public class Acteur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "prenom", nullable = false)
    private String prenom;
    @ManyToMany(mappedBy = "acteurs")
    private List<Film> films = new ArrayList<>();

}
