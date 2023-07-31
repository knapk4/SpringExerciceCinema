package fr.piga.cinemaspring.seances;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SeanceRepository extends JpaRepository<Seance, Long> {
    public List<Seance> findByDate(LocalDate date);
}
