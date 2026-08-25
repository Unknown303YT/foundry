package com.riverstone.unknown303.foundry.server.organization.member;

import java.util.UUID;

public record OrganizationMemberResponse(
        UUID accountId,
        UUID organizationId,
        UUID roleId
) {
}
