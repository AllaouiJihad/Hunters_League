package org.jihad.hunters_leagues.web.vm.responseVM;

import lombok.Getter;
import lombok.Setter;
import org.jihad.hunters_leagues.model.enums.Role;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProfileVM {

    private String username;

    private Role role;


    private String firstName;


    private String lastName;

    private String cin;


    private String email;

    private String nationality;

    private LocalDateTime joinDate;


    private LocalDateTime licenseExpirationDate;

}
