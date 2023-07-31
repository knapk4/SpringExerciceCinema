package fr.piga.cinemaspring.acteurs;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.piga.cinemaspring.acteurs.dto.ActeurCompletDto;
import fr.piga.cinemaspring.acteurs.dto.ActeurReduitDto;
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

    private final ObjectMapper mapper;

    public ActeurService(ActeurRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    /**
     * Récupère tous les acteurs
     * @return Une liste d'acteurs
     */
    public List<ActeurReduitDto> findAll() {
        List<Acteur> acteurs = repository.findAll();
        return acteurs.stream().map(acteur -> mapper.convertValue(acteur, ActeurReduitDto.class)).toList();
    }

    // SANS DTO
    //public List<Acteur> findAllActeurs() {
    //    return repository.findAll();
    //}

    /**
     * Sauvegarde un acteur
     * @param entity L'acteur à sauvegarder
     * @return L'acteur sauvegardé
     */
    public ActeurCompletDto save(Acteur entity) {
        Acteur entitySaved = repository.save(entity);
        return mapper.convertValue(entitySaved, ActeurCompletDto.class);
    }

    //SANS DTO
    //public Acteur save(Acteur entity) {
    //    return repository.save(entity);
    //}


    /**
     * Récupère un acteur par son id
     * @param id L'id de l'acteur à récupérer
     * @return L'acteur récupéré
     */
    public ActeurCompletDto findById(Long id) {
        Acteur acteur = repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Acteur non trouvé"));
        return mapper.convertValue(acteur, ActeurCompletDto.class);
    }

    // SANS DTO
    // public Acteur findById(Long id) {
    //        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    //    }

    /**
     * Supprime un acteur par son id
     * @param id L'id de l'acteur à supprimer
     */
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public Acteur findOrInsertActeur(Acteur acteur) {
        return repository.findById(acteur.getId()).orElseGet(() -> repository.save(acteur));
    }
}
