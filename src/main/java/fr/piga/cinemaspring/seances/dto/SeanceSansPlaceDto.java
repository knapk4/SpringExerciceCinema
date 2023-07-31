package fr.piga.cinemaspring.seances.dto;

import fr.piga.cinemaspring.films.dto.FilmReduitDto;
import fr.piga.cinemaspring.salles.dto.SalleSansPlaceDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class SeanceSansPlaceDto {
    private Integer id;
    private LocalDate date;
    private float prix;

    private FilmReduitDto film;

    private SalleSansPlaceDto salle;
}