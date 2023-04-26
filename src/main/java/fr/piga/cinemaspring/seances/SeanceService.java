package fr.piga.cinemaspring.seances;

import fr.piga.cinemaspring.salles.Salle;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SeanceService {

    private final SeanceRepository repository;

    public SeanceService(SeanceRepository repository) {
        this.repository = repository;
    }

    public Seance save(Seance entity) {
        return repository.save(entity);
    }

    public Seance update(Seance entity) {
        if (! this.repository.existsById(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "impossible de trouver l'Adresse a mettre à jour");
        }

        return repository.save(entity);
    }

    public List<Seance> findAll() {
        return repository.findAll();
    }

    public Seance findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

}
