package fr.piga.cinemaspring.salles;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.piga.cinemaspring.salles.dto.SalleCompletDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/salles")
public class SalleController {

    private final SalleService service;
    private final ObjectMapper mapper;

    public SalleController(SalleService service ,ObjectMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping("")
    public List<SalleCompletDto> findAll() {
        List<Salle> salles = service.findAll();
        return salles.stream().map(salle -> mapper.convertValue(salle, SalleCompletDto.class)).toList();
    }

    @PostMapping("")
    public SalleCompletDto save(@RequestBody Salle entity) {
        Salle nouvelleSalle = service.save(entity);
        return mapper.convertValue(nouvelleSalle, SalleCompletDto.class);
    }

    @PutMapping("/{id}") // ne pas oublier de mettre l'id dans le body et dans la requete
    public Salle update(@PathVariable Long id, @RequestBody Salle entity) {
        if(!id.equals(entity.getId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"L'id de l'entité ne correspond pas à l'id de la requête");
        }
        return this.service.update(entity);
    }

    @GetMapping("/{id}")
    public SalleCompletDto findById(@PathVariable Long id) {
        Salle salle = service.findById(id);
        return mapper.convertValue(salle, SalleCompletDto.class);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }

}
