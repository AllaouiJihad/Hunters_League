package org.jihad.hunters_leagues.web.vm.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.jihad.hunters_leagues.model.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
public class UserSearchResponseVm {
    private UUID id;
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
