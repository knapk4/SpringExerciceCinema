package fr.piga.cinemaspring.films;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.piga.cinemaspring.acteurs.Acteur;
import fr.piga.cinemaspring.acteurs.ActeurService;
import fr.piga.cinemaspring.acteurs.dto.ActeurReduitDto;
import jakarta.persistence.EntityManager;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * @Service est une annotation qui permet de déclarer une classe comme étant un bean Spring.
 * Cela permet de pouvoir l'injecter dans d'autres classes.
 *
 */
@Service
public class FilmService {

    private final FilmRepository repository;
    private final ActeurService service;
    private final ObjectMapper mapper;




    public FilmService(FilmRepository repository , ActeurService service, ObjectMapper mapper) {
        this.repository = repository;
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Cette méthode permet de récupérer tous les films de la base de données.
     * @return une liste de films
     */
    public List<Film> findAll() {
        return repository.findAll();
    }

    /**
     * Cette méthode permet de sauvegarder un film dans la base de données.
     * @param entity le film à sauvegarder
     * @return le film sauvegardé
     */
    public Film save(Film entity) {
        return repository.save(entity);
    }

    /**
     * Cette méthode permet de récupérer un film à partir de son identifiant.
     * @param id l'identifiant du film
     * @return le film correspondant à l'identifiant
     */
    public Film findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Cette méthode permet de supprimer un film à partir de son identifiant.
     * @param id l'identifiant du film
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Film addActeurById(Long id, Long idActeur) {
        Acteur acteur = new Acteur();
        acteur.setId(idActeur);
        return this.addActeur(id, acteur);
    }

    public Film addActeur(Long id, Acteur acteur) {
        Film film = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trouvé"));
        Acteur acteurSauvegarde = service.findOrInsertActeur(acteur);
        film.getActeurs().add(acteurSauvegarde);
        repository.save(film);
        return findById(id);
    }

    public List<ActeurReduitDto> findActeurs(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Film non trouvé"))
                .getActeurs().stream().map(acteur -> mapper.convertValue(acteur, ActeurReduitDto.class)).toList();
    }

}
