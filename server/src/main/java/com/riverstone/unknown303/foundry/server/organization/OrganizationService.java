package com.riverstone.unknown303.foundry.server.organization;

import com.riverstone.unknown303.foundry.server.account.Account;
import com.riverstone.unknown303.foundry.server.account.AccountService;
import com.riverstone.unknown303.foundry.server.organization.member.*;
import com.riverstone.unknown303.foundry.server.organization.role.OrganizationRole;
import com.riverstone.unknown303.foundry.server.organization.role.OrganizationRoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrganizationService {
    private final OrganizationRepository organizationRepository;
    private final OrganizationRoleRepository roleRepository;
    private final OrganizationMembershipRepository membershipRepository;
    private final AccountService accountService;

    public OrganizationService(
            OrganizationRepository organizationRepository,
            OrganizationRoleRepository roleRepository,
            OrganizationMembershipRepository membershipRepository,
            AccountService accountService
    ) {
        this.organizationRepository = organizationRepository;
        this.roleRepository = roleRepository;
        this.membershipRepository = membershipRepository;
        this.accountService = accountService;
    }

    @Transactional
    public Organization create(UUID creatorId, String name) {
        Account creator = accountService.findById(creatorId);

        Organization organization = new Organization(
                UUID.randomUUID(),
                name
        );

        organizationRepository.save(organization);

        OrganizationRole ownerRole = new OrganizationRole(
                UUID.randomUUID(),
                organization,
                "Owner",
                true
        );

        roleRepository.save(ownerRole);

        OrganizationMembership membership = new OrganizationMembership(
                UUID.randomUUID(),
                creator,
                organization,
                ownerRole
        );

        membershipRepository.save(membership);

        return organization;
    }

    public Organization findById(UUID id) {
        return organizationRepository.findById(id)
                .orElseThrow(() -> new OrganizationNotFoundException(id));
    }

    public List<Organization> findAll() {
        return organizationRepository.findAll();
    }

    public boolean isMember(UUID accountId, UUID organizationId) {
        Account account = accountService.findById(accountId);
        Organization organization = findById(organizationId);

        return membershipRepository.existsByAccountAndOrganization(
                account,
                organization
        );
    }

    public List<OrganizationMemberResponse> findMembers(UUID organizationId) {
        Organization organization = findById(organizationId);

        return membershipRepository.findByOrganization(organization)
                .stream()
                .map(membership -> new OrganizationMemberResponse(
                        membership.getAccount().getId(),
                        membership.getOrganization().getId(),
                        membership.getRole().getId()
                ))
                .toList();
    }

    public void delete(UUID id) {
        if (!organizationRepository.existsById(id))
            throw new OrganizationNotFoundException(id);

        organizationRepository.deleteById(id);
    }
}
