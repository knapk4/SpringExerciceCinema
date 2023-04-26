package fr.piga.cinemaspring.acteurs;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

/**
 * Service de l'entité Acteur
 * @see Acteur
 */
@Service
public class ActeurService {
    /**
     * Repository de l'entité Acteur pour la persistance des données
     * @see ActeurRepository
     * @see Acteur
     */
    private final ActeurRepository repository;

    public ActeurService(ActeurRepository repository) {
        this.repository = repository;
    }

    /**
     * Récupère tous les acteurs
     * @return Une liste d'acteurs
     */
    public List<Acteur> findAll() {
        return repository.findAll();
    }

    /**
     * Sauvegarde un acteur
     * @param entity L'acteur à sauvegarder
     * @return L'acteur sauvegardé
     */
    public Acteur save(Acteur entity) {
        return repository.save(entity);
    }

    /**
     * Récupère un acteur par son id
     * @param id L'id de l'acteur à récupérer
     * @return L'acteur récupéré
     */
    public Acteur findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    /**
     * Supprime un acteur par son id
     * @param id L'id de l'acteur à supprimer
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
