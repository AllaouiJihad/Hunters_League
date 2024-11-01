    package org.jihad.hunters_leagues.web.vm;

    import jakarta.validation.constraints.Email;
    import jakarta.validation.constraints.NotBlank;
    import jakarta.validation.constraints.Size;
    import lombok.Getter;
    import lombok.Setter;

    @Getter
    @Setter
    public class RegisterVm {

        @NotBlank(message = "Username is required")
        @Size(min = 3, max = 20, message = "Username must be between 3 and 20 characters")
        private String username;

        @NotBlank(message = "Password is required")
        private String password;

        @NotBlank(message = "First name is required")
        @Size(max = 30, message = "First name must be at most 30 characters")
        private String firstName;

        @NotBlank(message = "Last name is required")
        @Size(max = 30, message = "Last name must be at most 30 characters")
        private String lastName;

        @NotBlank(message = "CIN is required")
        private String cin;

        @NotBlank(message = "Email is required")
        @Email(message = "Email should be valid")
        private String email;

        @NotBlank(message = "Nationality is required")
        private String nationality;
    }
