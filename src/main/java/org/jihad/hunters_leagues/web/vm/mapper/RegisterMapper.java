package org.jihad.hunters_leagues.web.vm.mapper;

import org.jihad.hunters_leagues.model.User;
import org.jihad.hunters_leagues.web.vm.RegisterVm;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface RegisterMapper {

    RegisterVm toDto(User user);
    User toEntity(RegisterVm registerVm);
}
