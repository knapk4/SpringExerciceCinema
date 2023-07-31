package fr.piga.cinemaspring.tickets;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.piga.cinemaspring.tickets.dto.TicketCompletDto;
import fr.piga.cinemaspring.tickets.dto.TicketReduitDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tickets")
public class TicketController {

    private final TicketService service;
    private final ObjectMapper mapper;

    public TicketController(TicketService service, ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("")
    public List<Ticket> findAll() {
        List<Ticket> tickets = service.findAll();
        return tickets.stream().map(ticket -> mapper.convertValue(ticket, Ticket.class)).toList();
    }

    @PostMapping("")
    public TicketReduitDto save(@RequestBody Ticket entity) {
        Ticket nouveauTicket = service.save(entity);
        return mapper.convertValue(nouveauTicket, TicketReduitDto.class);
    }

    @PutMapping("/{id}") // ne pas oublier de mettre l'id dans le body et dans la requete
    public Ticket update(@PathVariable Long id, @RequestBody Ticket entity) {
        if(!id.equals(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id de l'entité ne correspond pas à l'id de la requête");
        }
        return this.service.update(entity);
    }

    @GetMapping("/{id}")
    public TicketCompletDto findById(@PathVariable Long id) {
        Ticket ticket =  service.findById(id);
        return mapper.convertValue(ticket, TicketCompletDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
