package fr.piga.cinemaspring.films;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.piga.cinemaspring.acteurs.Acteur;
import fr.piga.cinemaspring.acteurs.dto.ActeurReduitDto;
import fr.piga.cinemaspring.films.dto.FilmCompletDto;
import fr.piga.cinemaspring.films.dto.FilmReduitDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Cette classe permet de définir les routes de l'API REST pour les films.
 * @RestController est une annotation qui permet de déclarer une classe comme étant un contrôleur Spring.
 * Cela permet de pouvoir définir des routes pour l'API REST.
 */
@RestController
@RequestMapping("/films")
public class FilmController {

    private final FilmService service;
    private final ObjectMapper mapper;

    public FilmController(FilmService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    /**
     * Cette méthode permet de récupérer tous les films de la base de données.
     * @return une liste de films
     */
    @GetMapping("")
    public List<FilmReduitDto> findAll() {
        List<Film> films = service.findAll();
        return films.stream().map(film -> mapper.convertValue(film, FilmReduitDto.class)).toList();
    }

    /**
     * Cette méthode permet de sauvegarder un film dans la base de données.
     * @param film le film à sauvegarder
     * @return le film sauvegardé
     */
    @PostMapping("")
    public Film save(@RequestBody Film film) {
        return service.save(film);
    }

    /**
     * Cette méthode permet de récupérer un film à partir de son identifiant.
     * @param id l'identifiant du film
     * @return le film correspondant à l'identifiant
     */
    @GetMapping("/{id}")
    public FilmCompletDto findById(@PathVariable Long id) {
        Film film = service.findById(id);
        return mapper.convertValue(film, FilmCompletDto.class);
    }

    /**
     * Cette méthode permet de supprimer un film à partir de son identifiant.
     * @param id l'identifiant du film
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @PutMapping("")
    public FilmCompletDto update(@RequestBody Film film) {
        Film entite = service.save(film);
        return mapper.convertValue(entite, FilmCompletDto.class);
    }
    @PostMapping("{id}/acteurs/{idActeur}")
    public FilmCompletDto addActeurById(@PathVariable Long id, @PathVariable Long idActeur) {
        Film entite = service.addActeurById(id, idActeur);
        return mapper.convertValue(entite, FilmCompletDto.class);
    }

    @PostMapping("{id}/acteurs")
    public FilmCompletDto addActeur(@PathVariable Long id, @RequestBody Acteur acteur) {
        Film entite = service.addActeur(id, acteur);
        return mapper.convertValue(entite, FilmCompletDto.class);
    }

    @GetMapping("{id}/acteurs")
    public List<ActeurReduitDto> findActeurs(@PathVariable Long id) {
        return service.findActeurs(id);
    }
}
