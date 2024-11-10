package org.jihad.hunters_leagues.web.vm.mapper;

import org.jihad.hunters_leagues.model.Species;
import org.jihad.hunters_leagues.web.vm.requestVM.SpeciesSaveVM;
import org.jihad.hunters_leagues.web.vm.requestVM.SpeciesUpdateVM;
import org.jihad.hunters_leagues.web.vm.responseVM.SpeciesVM;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface SpeciesMapper {
    SpeciesMapper Instance = Mappers.getMapper(SpeciesMapper.class);

    SpeciesSaveVM speciesToSpeciesSaveVM(Species species);

    Species speciesSaveVMToSpecies(SpeciesSaveVM speciesSaveVM);

    Species speciesUpdateVMToSpecies(SpeciesUpdateVM speciesUpdateVM);

    SpeciesUpdateVM speciesToSpeciesUpdateVM(Species species);

    SpeciesVM speciesToSpeciesVM(Species species);

    Species speciesVMToSpecies(SpeciesVM speciesVM);


}
