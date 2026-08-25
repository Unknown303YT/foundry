package com.riverstone.unknown303.foundry.server.organization;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CreateOrganizationRequest(
        @NotBlank
        @Size(min = 1, max = 100)
        String name
) {
}
