package org.jihad.hunters_leagues.web.vm.mapper;

import org.jihad.hunters_leagues.model.User;
import org.jihad.hunters_leagues.web.vm.LoginVm;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface LoginMapper {
    User toEntity(LoginVm loginVm);
    LoginVm toDto(User user);
}
