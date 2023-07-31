package fr.piga.cinemaspring.films.dto;

import fr.piga.cinemaspring.acteurs.dto.ActeurReduitDto;
import lombok.Data;

import java.util.List;

@Data
public class FilmSansRealisateurDto {
    private Long id;
    private String titre;
    private Integer duree;
    private List<ActeurReduitDto> acteurs;

}
