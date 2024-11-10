package org.jihad.hunters_leagues.web.vm.mapper;

import org.jihad.hunters_leagues.model.Participation;
import org.jihad.hunters_leagues.web.vm.responseVM.ParticipationVM;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CompetitionMapper.class})
public interface ParticipationMapper {

    @Mapping(source = "user", target = "user")
    @Mapping(source = "competition", target = "competition")
    ParticipationVM participationToParticipationVM(Participation participation);

    @Mapping(source = "user", target = "user")
    @Mapping(source = "competition", target = "competition")
    Participation participationVMToParticipation(ParticipationVM participationVM);
}
