package fr.piga.cinemaspring.realisateurs;

import com.fasterxml.jackson.databind.ObjectMapper;
import fr.piga.cinemaspring.realisateurs.dto.RealisateurCompletDto;
import fr.piga.cinemaspring.realisateurs.dto.RealisateurSansFilmDto;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class RealisateurService {

    private final RealisateurRepository repository;
    private final ObjectMapper mapper;

    public RealisateurService(RealisateurRepository repository, ObjectMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public List<RealisateurSansFilmDto> findAll() {

        List<Realisateur> realisateurs = repository.findAll();
        return realisateurs.stream().map(realisateur -> mapper.convertValue(realisateur, RealisateurSansFilmDto.class)).toList();
    }

    public RealisateurCompletDto save(Realisateur entity) {
        Realisateur realisateur =  repository.save(entity);
        return mapper.convertValue(realisateur, RealisateurCompletDto.class);
    }

    public RealisateurCompletDto findById(Long id) {
        Realisateur realisateur =  repository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        return mapper.convertValue(realisateur, RealisateurCompletDto.class);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }


}
