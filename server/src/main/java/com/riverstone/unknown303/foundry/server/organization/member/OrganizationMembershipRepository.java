package com.riverstone.unknown303.foundry.server.organization.member;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizationMembershipRepository extends JpaRepository<OrganizationMembership, UUID> {
    boolean existsByAccountIdAndOrganizationId(UUID accountId, UUID organizationId);
    List<OrganizationMembership> findByOrganizationId(UUID organizationId);
    List<OrganizationMembership> findByAccountId(UUID accountId);

    boolean existsByAccountIdAndOrganizationIdAndRoleId(
            UUID accountId,
            UUID organizationId,
            UUID roleId
    );
}
