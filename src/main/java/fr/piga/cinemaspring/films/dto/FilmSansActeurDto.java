package fr.piga.cinemaspring.films.dto;

import fr.piga.cinemaspring.realisateurs.Realisateur;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class FilmSansActeurDto {
    private Long id;
    private String titre;
    private String duree;
    private List<Realisateur> realisateurs = new ArrayList<>();
}
