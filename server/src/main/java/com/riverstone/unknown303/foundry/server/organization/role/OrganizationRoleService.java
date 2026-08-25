package com.riverstone.unknown303.foundry.server.organization.role;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationRoleService {
    private final OrganizationRoleRepository repository;

    public OrganizationRoleService(OrganizationRoleRepository repository) {
        this.repository = repository;
    }

    public List<OrganizationRole> findByOrganization(UUID organizationId) {
        return repository.findByOrganizationId(organizationId);
    }

    public OrganizationRole findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new RoleNotFoundException(id));
    }
}
