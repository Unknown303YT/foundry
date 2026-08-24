package com.riverstone.unknown303.foundry.server.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateAccountRequest(
        @NotBlank
        @Size(min = 3, max = 32)
        String username,

        @NotBlank
        @Email
        String email) {
}
