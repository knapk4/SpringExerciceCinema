package fr.piga.cinemaspring.acteurs.dto;

import fr.piga.cinemaspring.films.dto.FilmReduitDto;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ActeurCompletDto {
    private Long id;
    private String nom;
    private String prenom;
    private List<FilmReduitDto> films = new ArrayList<>();// a ajouter apres avoir cree la classe FilmReduitDto

}
