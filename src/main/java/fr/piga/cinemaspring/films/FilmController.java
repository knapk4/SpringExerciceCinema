package fr.piga.cinemaspring.films;

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

    public FilmController(FilmService service) {
        this.service = service;
    }

    /**
     * Cette méthode permet de récupérer tous les films de la base de données.
     * @return une liste de films
     */
    @GetMapping("")
    public List<Film> findAll() {
        return service.findAll();
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
    public Film findById(@PathVariable Long id) {
        return service.findById(id);
    }

    /**
     * Cette méthode permet de supprimer un film à partir de son identifiant.
     * @param id l'identifiant du film
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
