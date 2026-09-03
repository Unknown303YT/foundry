package com.riverstone.unknown303.foundry.server.organization.member;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationMembershipService {
    private final OrganizationMembershipRepository repository;

    public OrganizationMembershipService(OrganizationMembershipRepository repository) {
        this.repository = repository;
    }

    public OrganizationMembership findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new MembershipNotFoundException(id));
    }

    public List<OrganizationMembership> findByOrganization(UUID organizationId) {
        return repository.findByOrganizationId(organizationId);
    }

    public List<OrganizationMembership> findByAccount(UUID accountId) {
        return repository.findByAccountId(accountId);
    }

    public boolean exists(UUID accountId, UUID organizationId) {
        return repository.existsByAccountIdAndOrganizationId(accountId, organizationId);
    }

    public OrganizationMembership findByAccountIdAndOrganizationId(UUID accountId, UUID organizationId) {
        return repository.findByAccountIdAndOrganizationId(accountId, organizationId)
                .orElseThrow(() -> new MembershipNotFoundException(accountId, organizationId));
    }
}
