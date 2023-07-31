package fr.piga.cinemaspring.realisateurs.dto;

import fr.piga.cinemaspring.films.dto.FilmReduitDto;
import lombok.Data;

import java.util.List;

@Data
public class RealisateurCompletDto {
    private Long id;
    private String nom;
    private String prenom;
    private List<FilmReduitDto> films;
}