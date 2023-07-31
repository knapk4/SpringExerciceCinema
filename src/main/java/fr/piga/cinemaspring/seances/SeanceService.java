package fr.piga.cinemaspring.seances;

import fr.piga.cinemaspring.salles.Salle;
import fr.piga.cinemaspring.salles.SalleService;
import fr.piga.cinemaspring.tickets.Ticket;
import fr.piga.cinemaspring.tickets.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;

@Service
public class SeanceService {

    private final SeanceRepository repository;
    private final TicketService ticketService;
    private final SalleService salleService;

    public SeanceService(SeanceRepository repository , TicketService ticketService, SalleService salleService) {
        this.repository = repository;
        this.ticketService = ticketService;
        this.salleService = salleService;
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

    public List<Seance> findByDate(String date) {
        LocalDate dateRecherche = LocalDate.parse(date);
        return repository.findByDate(dateRecherche);
    }

    public Ticket reserver(Long id, Ticket ticket) {
        Seance seance = findById(id);
        if (seance.getPlacesLibres() < ticket.getNbPlaces()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Pas assez de places disponibles");
        } else {
            seance.setPlacesLibres(seance.getPlacesLibres() - ticket.getNbPlaces());
            update(seance);
            return ticketService.save(ticket);
        }
    }

    public List<Ticket> getTickets(Long id) {
        return ticketService.findBySeanceId(id);
    }

}
