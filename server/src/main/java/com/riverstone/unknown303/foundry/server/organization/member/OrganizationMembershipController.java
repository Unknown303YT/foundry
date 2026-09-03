package com.riverstone.unknown303.foundry.server.organization.member;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/")
public class OrganizationMembershipController {
    private final OrganizationMembershipService service;

    public OrganizationMembershipController(OrganizationMembershipService service) {
        this.service = service;
    }

    @GetMapping("/memberships/{id}")
    public OrganizationMembership findById(
            @PathVariable UUID id
    ) {
        return service.findById(id);
    }

    @GetMapping("/organizations/{organizationId}/members")
    public List<OrganizationMembership> findByOrganization(@PathVariable UUID organizationId) {
        return service.findByOrganization(organizationId);
    }

    @GetMapping("/accounts/{accountId}/memberships")
    public List<OrganizationMembership> findByAccount(@PathVariable UUID accountId) {
        return service.findByAccount(accountId);
    }
}
