package fr.piga.cinemaspring.seances;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.piga.cinemaspring.seances.dto.SeanceCompletDto;
import fr.piga.cinemaspring.tickets.Ticket;
import fr.piga.cinemaspring.tickets.TicketService;
import fr.piga.cinemaspring.tickets.dto.TicketCompletDto;
import fr.piga.cinemaspring.tickets.dto.TicketReduitDto;
import fr.piga.cinemaspring.tickets.dto.TicketSansSeanceDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public class SeanceController {

    private final SeanceService service;
    private final TicketService ticketService;
    private final ObjectMapper mapper;
    public SeanceController(SeanceService service, TicketService ticketService, ObjectMapper mapper) {
        this.service = service;
        this.ticketService = ticketService;
        this.mapper = mapper;
    }

    @GetMapping("")
    public List<SeanceCompletDto> findAll() {
        List<Seance> seances = service.findAll();
        return seances.stream().map(seance -> mapper.convertValue(seance, SeanceCompletDto.class)).toList();
    }

    @PostMapping("")
    public SeanceCompletDto save(@RequestBody Seance entity) {
        Seance nouvelleSeance = service.save(entity);
        return mapper.convertValue(nouvelleSeance, SeanceCompletDto.class);
    }

    @PutMapping("/{id}") // ne pas oublier de mettre l'id dans le body et dans la requete
    public Seance update(@PathVariable Long id, @RequestBody Seance entity) {
        if(!id.equals(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id de l'entité ne correspond pas à l'id de la requête");
        }
        return this.service.update(entity);
    }

    @GetMapping("/{id}")
    public SeanceCompletDto findById(@PathVariable Long id) {
        Seance seance =  service.findById(id);
        return mapper.convertValue(seance, SeanceCompletDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

    @GetMapping("/date")
    public List<SeanceCompletDto> findByDate(@RequestParam String date) {
        List<Seance> seances = service.findByDate(date);
        return seances.stream().map(seance -> mapper.convertValue(seance, SeanceCompletDto.class)).toList();
    }

    @GetMapping("{id}/tickets")
    public List<TicketCompletDto> getTickets(@PathVariable Long id) {
        List<Ticket> tickets = service.getTickets(id);
        return tickets.stream().map(ticket -> mapper.convertValue(ticket, TicketCompletDto.class)).toList();
    }

    @PostMapping("{id}/reserver")
    public TicketReduitDto reserver(@PathVariable Long id, @RequestBody TicketSansSeanceDto ticketACreer) {
        Ticket ticket = mapper.convertValue(ticketACreer, Ticket.class);
        ticket.setSeance(service.findById(id));
        service.reserver(id, ticket);
        return mapper.convertValue(ticket, TicketReduitDto.class);
    }

}
