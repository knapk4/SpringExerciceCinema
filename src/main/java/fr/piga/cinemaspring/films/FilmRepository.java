package fr.piga.cinemaspring.films;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;

public interface FilmRepository extends JpaRepository<Film, Long> {
    <List> Film findByTitre(String titre);

    <List> Film findByTitreContaining(String titre);

    <List> Film findByDateSortie(LocalDate dateSortie);

    <List> Film findByDateSortieBetween(LocalDate dateDebut, LocalDate dateFin);
}
