package org.jihad.hunters_leagues.repository;



import org.jihad.hunters_leagues.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpeciesRepositroy extends JpaRepository<Species, UUID>, JpaSpecificationExecutor<Species> {


}
