package com.riverstone.unknown303.foundry.server.organization.member;

import com.riverstone.unknown303.foundry.server.account.Account;
import com.riverstone.unknown303.foundry.server.account.AccountService;
import com.riverstone.unknown303.foundry.server.organization.Organization;
import com.riverstone.unknown303.foundry.server.organization.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationMembershipService {
    private final OrganizationMembershipRepository repository;
    private final AccountService accountService;
    private final OrganizationService organizationService;

    public OrganizationMembershipService(
            OrganizationMembershipRepository repository,
            AccountService accountService,
            OrganizationService organizationService
    ) {
        this.repository = repository;
        this.accountService = accountService;
        this.organizationService = organizationService;
    }

    public OrganizationMembership findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new MembershipNotFoundException(id));
    }

    public List<OrganizationMembership> findByOrganization(UUID organizationId) {
        Organization organization = organizationService.findById(organizationId);

        return repository.findByOrganization(organization);
    }

    public List<OrganizationMembership> findByAccount(UUID accountId) {
        Account account = accountService.findById(accountId);

        return repository.findByAccount(account);
    }

    public boolean exists(UUID accountId, UUID organizationId) {
        Account account = accountService.findById(accountId);
        Organization organization = organizationService.findById(organizationId);

        return repository.existsByAccountAndOrganization(
                account,
                organization
        );
    }

    public OrganizationMembership findByAccountIdAndOrganizationId(
            UUID accountId,
            UUID organizationId
    ) {
        Account account = accountService.findById(accountId);
        Organization organization = organizationService.findById(organizationId);

        return repository.findByAccountAndOrganization(
                account,
                organization
        ).orElseThrow(
                () -> new MembershipNotFoundException(accountId, organizationId)
        );
    }
}
