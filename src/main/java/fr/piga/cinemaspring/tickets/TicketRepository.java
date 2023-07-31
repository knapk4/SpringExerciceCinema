package fr.piga.cinemaspring.tickets;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    public List<Ticket> findBySeanceId(Long id);
}
