package fr.piga.cinemaspring.tickets.dto;

import fr.piga.cinemaspring.seances.dto.SeanceCompletDto;
import lombok.Data;

@Data
public class TicketCompletDto {
    private Long id;
    private String nomClient;
    private Integer nombrePlaces;
    private SeanceCompletDto seance;
}