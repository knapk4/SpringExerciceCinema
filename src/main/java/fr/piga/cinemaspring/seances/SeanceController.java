package fr.piga.cinemaspring.seances;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SeanceController {

    private final SeanceService service;

    public SeanceController(SeanceService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Seance> findAll() {
        return service.findAll();
    }

    @PostMapping("")
    public Seance save(@RequestBody Seance entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}") // ne pas oublier de mettre l'id dans le body et dans la requete
    public Seance update(@PathVariable Long id, @RequestBody Seance entity) {
        if(!id.equals(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id de l'entité ne correspond pas à l'id de la requête");
        }
        return this.service.update(entity);
    }

    @GetMapping("/{id}")
    public Seance findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
