package fr.piga.cinemaspring.seances.dto;

import fr.piga.cinemaspring.films.dto.FilmReduitDto;
import fr.piga.cinemaspring.salles.dto.SalleSansPlaceDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SeanceCompletDto {
    private Long id;
    private LocalDate date;
    private Integer placesDispo;
    private float prix;
    private FilmReduitDto film;
    private SalleSansPlaceDto salle;
}