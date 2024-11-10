package org.jihad.hunters_leagues.web.vm.requestVM;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;
import org.jihad.hunters_leagues.model.enums.Difficulty;
import org.jihad.hunters_leagues.model.enums.SpeciesType;

import java.util.UUID;

@Getter
@Setter
public class SpeciesUpdateVM {

    private UUID id;

    @NotBlank
    private String name;

    @Enumerated(EnumType.STRING)
    @NotNull
    private SpeciesType category;

    @NotNull
    @Positive
    private Double minimumWeight;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Difficulty difficulty;

    @NotNull
    @Positive
    private Integer points;
}
