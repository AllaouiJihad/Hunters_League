package org.jihad.hunters_leagues.service.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UserDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String cin;
    private String email;
    private String nationality;
}
