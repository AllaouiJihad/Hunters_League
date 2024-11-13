package org.jihad.hunters_leagues.service;

import org.jihad.hunters_leagues.exception.SpeciesNotFoundException;
import org.jihad.hunters_leagues.model.Species;
import org.jihad.hunters_leagues.model.enums.SpeciesType;
import org.jihad.hunters_leagues.repository.SpeciesRepositroy;
import org.jihad.hunters_leagues.service.interfaces.SpecieService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.Optional;
import java.util.UUID;

public class SpecieServiceImpl implements SpecieService {
    private  SpeciesRepositroy speciesRepository;

    public SpecieServiceImpl(SpeciesRepositroy speciesRepository) {
        this.speciesRepository = speciesRepository;
    }

    public Species save(Species species) {
        return speciesRepository.save(species);
    }

    public Species update(Species species) {
        return speciesRepository.save(species);
    }

    public void delete(UUID id) {
        speciesRepository.deleteById(id);
    }

    public Species findById(UUID id) {
        return speciesRepository.findById(id).orElseThrow(SpeciesNotFoundException::new);
    }

    public Page<Species> filterByType(int page, int size, Optional<SpeciesType> category) {
        Pageable pageable = PageRequest.of(page, size);


        Specification<Species> spec = (root, query, cb) -> {
            if (category.isPresent()) {
                return cb.equal(root.get("category"), category.get());
            }
            return cb.conjunction();
        };

        return speciesRepository.findAll(spec, pageable);
    }
}
