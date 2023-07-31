package fr.piga.cinemaspring.films.dto;

import fr.piga.cinemaspring.acteurs.dto.ActeurReduitDto;
import fr.piga.cinemaspring.realisateurs.dto.RealisateurSansFilmDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
public class FilmCompletDto {
    private Long id;
    private String titre;
    private LocalDate dateSortie;
    private String duree;
    private String resume;
    private List<ActeurReduitDto> acteurs = new ArrayList<>();
    private List<RealisateurSansFilmDto> realisateurs = new ArrayList<>();
}
