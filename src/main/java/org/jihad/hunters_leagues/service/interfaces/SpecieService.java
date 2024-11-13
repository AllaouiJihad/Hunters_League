package org.jihad.hunters_leagues.service.interfaces;

import org.jihad.hunters_leagues.model.Species;
import org.jihad.hunters_leagues.model.enums.SpeciesType;
import org.springframework.data.domain.Page;

import java.util.Optional;
import java.util.UUID;

public interface SpecieService {
    Species save(Species species);
    Species update(Species species);
    void delete(UUID id);
    Species findById(UUID id);
}
