package fr.piga.cinemaspring.tickets.dto;

import fr.piga.cinemaspring.seances.dto.SeanceSansPlaceDto;
import lombok.Data;

@Data
public class TicketReduitDto {
    private Long id;
    private String nomClient;
    private Integer nombrePlaces;
    private SeanceSansPlaceDto seance;
}