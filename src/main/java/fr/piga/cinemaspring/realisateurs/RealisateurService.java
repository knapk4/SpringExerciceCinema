package fr.piga.cinemaspring.realisateurs;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {

    private final RealisateurRepository repository;

    public RealisateurService(RealisateurRepository repository) {
        this.repository = repository;
    }

    public Realisateur save(Realisateur entity) {
        return repository.save(entity);
    }

    public List<Realisateur> findAll() {
        return repository.findAll();
    }

    public Realisateur findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
