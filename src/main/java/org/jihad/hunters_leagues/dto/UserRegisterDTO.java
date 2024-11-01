package org.jihad.hunters_leagues.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDTO {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String cin;
    private String email;
    private String nationality;
}
