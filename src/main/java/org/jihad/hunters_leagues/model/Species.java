package org.jihad.hunters_leagues.model;


import jakarta.persistence.*;
import lombok.*;
import org.jihad.hunters_leagues.model.enums.Difficulty;
import org.jihad.hunters_leagues.model.enums.SpeciesType;

import java.util.UUID;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private SpeciesType category;

    private Double minimumWeight;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;

    private Integer points;

}
