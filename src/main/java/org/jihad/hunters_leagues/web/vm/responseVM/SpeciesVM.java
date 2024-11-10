package org.jihad.hunters_leagues.web.vm.responseVM;

import lombok.Getter;
import lombok.Setter;
import org.jihad.hunters_leagues.model.enums.Difficulty;
import org.jihad.hunters_leagues.model.enums.SpeciesType;

import java.util.UUID;

@Getter
@Setter
public class SpeciesVM {

    private UUID id;

    private String name;

    private SpeciesType category;

    private Double minimumWeight;

    private Difficulty difficulty;

    private Integer points;
}
