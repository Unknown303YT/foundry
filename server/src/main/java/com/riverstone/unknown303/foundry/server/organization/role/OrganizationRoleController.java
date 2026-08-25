package com.riverstone.unknown303.foundry.server.organization.role;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class OrganizationRoleController {
    private final OrganizationRoleService service;

    public OrganizationRoleController(OrganizationRoleService service) {
        this.service = service;
    }

    @GetMapping("/organizations/{organizationId}/roles")
    public List<OrganizationRole> findByOrganization(@PathVariable UUID organizationId) {
        return service.findByOrganization(organizationId);
    }

    @GetMapping("/organizations/roles/{id}")
    public OrganizationRole findById(@PathVariable UUID id) {
        return service.findById(id);
    }
}
