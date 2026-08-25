package com.riverstone.unknown303.foundry.server.organization.role;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrganizationRoleRepository extends JpaRepository<OrganizationRole, UUID> {
    List<OrganizationRole> findByOrganizationId(UUID organizationId);
}
