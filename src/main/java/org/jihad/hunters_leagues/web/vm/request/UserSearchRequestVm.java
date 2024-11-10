package org.jihad.hunters_leagues.web.vm.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserSearchRequestVm {

    @NotBlank(message = "Le mot-clé de recherche ne peut pas être vide")
    private String keyword;


}
