package org.jihad.hunters_leagues.web.vm.mapper;

import org.jihad.hunters_leagues.model.User;
import org.jihad.hunters_leagues.web.vm.requestVM.LoginVM;
import org.jihad.hunters_leagues.web.vm.requestVM.RegisterVM;
import org.jihad.hunters_leagues.web.vm.requestVM.UserVM;
import org.jihad.hunters_leagues.web.vm.responseVM.ProfileVM;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    LoginVM userToLogin(User user);

    User loginToUser(LoginVM loginVM);

    ProfileVM userToProfileVM(User user);

    User profileVMToUser(ProfileVM profileVM);

    RegisterVM userToRegister(User user);

    User registerToUser(RegisterVM registerVM);

    User userVMToUser(UserVM userVM);

    UserVM userToUserVM(User user);
}
