package fr.piga.cinemaspring.tickets;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class TicketService {

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public Ticket save(Ticket ticket) {
        return repository.save(ticket);
    }

    public Ticket update(Ticket entity) {
        if (! this.repository.existsById(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "impossible de trouver l'Adresse a mettre à jour");
        }

        return repository.save(entity);
    }

    public Ticket findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Ticket> findAll() {
        return repository.findAll();
    }
}
