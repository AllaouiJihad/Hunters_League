package org.jihad.hunters_leagues.web.vm.requestVM;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;
import org.jihad.hunters_leagues.model.enums.Role;

import java.time.LocalDateTime;
import java.util.UUID;

@Setter
@Getter
public class UserVM {

    private UUID id;

    @NotBlank
    private String username;

    @Enumerated(EnumType.STRING)
    @NotNull
    private Role role;

    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;

    @NotBlank
    @Column(unique = true)
    private String cin;

    @NotBlank
    @Email
    private String email;

    private String nationality;

    @PastOrPresent(message = "Join date cannot be in the future.")
    private LocalDateTime joinDate;

    @Future
    private LocalDateTime licenseExpirationDate;
}
