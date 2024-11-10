package org.jihad.hunters_leagues.web.vm.mapper;

import org.jihad.hunters_leagues.model.Competition;
import org.jihad.hunters_leagues.web.vm.requestVM.CompetitionSaveVM;
import org.jihad.hunters_leagues.web.vm.requestVM.CompetitionUpdateVM;
import org.jihad.hunters_leagues.web.vm.responseVM.CompetitionVM;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CompetitionMapper {
    CompetitionMapper Instance = Mappers.getMapper(CompetitionMapper.class);

    CompetitionVM competitionToCompetitionVM(Competition competition);

    Competition competitionVMToCompetition(CompetitionVM competitionVM);

    CompetitionSaveVM competitionToCompetitionSaveVM(Competition competition);

    Competition competitionSaveVMToCompetition(CompetitionSaveVM competitionSaveVM);

    CompetitionUpdateVM competitionToCompetitionUpdateVM(Competition competition);

    Competition competitionUpdateVMToCompetition(CompetitionUpdateVM competitionUpdateVM);
}
