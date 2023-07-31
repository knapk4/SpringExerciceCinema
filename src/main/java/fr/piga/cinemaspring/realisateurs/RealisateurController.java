package fr.piga.cinemaspring.realisateurs;

import fr.piga.cinemaspring.realisateurs.dto.RealisateurCompletDto;
import fr.piga.cinemaspring.realisateurs.dto.RealisateurSansFilmDto;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/realisateurs")
public class RealisateurController {

    private final RealisateurService service;

    public RealisateurController(RealisateurService service) {
        this.service = service;
    }

    @GetMapping("")
    public List<RealisateurSansFilmDto> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public RealisateurCompletDto findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("")
    public RealisateurCompletDto save(@RequestBody Realisateur entity) {
        return service.save(entity);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
