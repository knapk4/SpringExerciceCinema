package fr.piga.cinemaspring.tickets.dto;

import lombok.Data;

@Data
public class TicketSansSeanceDto {
    private Long id;
    private String nomClient;
    private Integer nombrePlaces;
}