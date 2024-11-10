package org.jihad.hunters_leagues.repository;


import org.jihad.hunters_leagues.model.Hunt;
import org.jihad.hunters_leagues.model.Participation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface HuntRepository extends JpaRepository<Hunt, UUID> {
    List<Hunt> findHuntByParticipation(Participation participation);
}
