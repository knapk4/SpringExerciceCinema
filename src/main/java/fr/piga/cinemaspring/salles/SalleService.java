package fr.piga.cinemaspring.salles;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SalleService {

    private final SalleRepository repository;

    public SalleService(SalleRepository repository) {
        this.repository = repository;
    }

    public Salle save(Salle entity) {
        return repository.save(entity);
    }

    public Salle update(Salle entity) {
        if (! this.repository.existsById(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "impossible de trouver l'Adresse a mettre à jour");
        }

        return repository.save(entity);
    }

    public List<Salle> findAll() {
        return repository.findAll();
    }

    public Salle findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
