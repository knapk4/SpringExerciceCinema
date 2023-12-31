package fr.piga.cinemaspring.acteurs;

import fr.piga.cinemaspring.acteurs.dto.ActeurCompletDto;
import fr.piga.cinemaspring.acteurs.dto.ActeurReduitDto;
import org.springframework.web.bind.annotation.*;


import java.util.List;

/**
 * Controller de l'entité Acteur pour la gestion des requêtes HTTP
 * @see Acteur
 * @see ActeurService
 */
@RestController
@RequestMapping("/acteurs")
public class ActeurController {

    private final ActeurService service;

    public ActeurController(ActeurService service) {
        this.service = service;
    }
    /**
     * Récupère tous les acteurs
     * @return Une liste d'acteurs
     */
    @GetMapping("")
    public List<ActeurReduitDto> findAll() {
        return service.findAll();
    }

    // SANS DTO
    //@GetMapping("")
    //    public List<Acteur> findAll() {
    //        return service.findAll();
    //    }


    /**
     * Sauvegarde un acteur
     * @param entity L'acteur à sauvegarder
     * @return L'acteur sauvegardé
     */
    @PostMapping("")
    public ActeurCompletDto save(@RequestBody Acteur entity) {
        return service.save(entity);
    }

    // SANS DTO
    //@PostMapping("")
    //    public Acteur save(@RequestBody Acteur entity) {
    //        return service.save(entity);
    //    }

    /**
     * Récupère un acteur par son id
     * @param id L'id de l'acteur à récupérer
     * @return L'acteur récupéré
     */
    @GetMapping("/{id}")
    public ActeurCompletDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    // SANS DTO
    //@GetMapping("/{id}")
    //    public Acteur findById(@PathVariable Long id) {
    //        return service.findById(id);
    //    }

    /**
     * Supprime un acteur par son id
     * @param id L'id de l'acteur à supprimer
     */
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
