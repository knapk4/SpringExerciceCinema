package fr.piga.cinemaspring.tickets;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;

    public TicketController(TicketService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<Ticket> findAll() {
        return service.findAll();
    }

    @PostMapping("")
    public Ticket save(@RequestBody Ticket entity) {
        return service.save(entity);
    }

    @PutMapping("/{id}") // ne pas oublier de mettre l'id dans le body et dans la requete
    public Ticket update(@PathVariable Long id, @RequestBody Ticket entity) {
        if(!id.equals(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id de l'entité ne correspond pas à l'id de la requête");
        }
        return this.service.update(entity);
    }

    @GetMapping("/{id}")
    public Ticket findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
