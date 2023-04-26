package fr.piga.cinemaspring.salles;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleService service;

    public SalleController(SalleService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Salle> findAll() {
        return service.findAll();
    }

    @PostMapping("")
    public Salle save(@RequestBody Salle entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}") // ne pas oublier de mettre l'id dans le body et dans la requete
    public Salle update(@PathVariable Long id, @RequestBody Salle entity) {
        if(!id.equals(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id de l'entité ne correspond pas à l'id de la requête");
        }
        return this.service.update(entity);
    }

    @GetMapping("/{id}")
    public Salle findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
