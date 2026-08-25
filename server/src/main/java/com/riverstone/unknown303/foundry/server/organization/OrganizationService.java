package com.riverstone.unknown303.foundry.server.organization;

import com.riverstone.unknown303.foundry.server.account.Account;
import com.riverstone.unknown303.foundry.server.account.AccountService;
import com.riverstone.unknown303.foundry.server.organization.member.*;
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
                organization.getId(),
                "Owner",
                true
        );

        roleRepository.save(ownerRole);

        OrganizationMembership membership = new OrganizationMembership(
                UUID.randomUUID(),
                creator.getId(),
                organization.getId(),
                ownerRole.getId()
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
        return membershipRepository.existsByAccountIdAndOrganizationId(
                accountId,
                organizationId
        );
    }

    public List<OrganizationMemberResponse> findMembers(UUID organizationId) {
        findById(organizationId);

        return membershipRepository.findByOrganizationId(organizationId)
                .stream()
                .map(membership -> new OrganizationMemberResponse(
                        membership.getAccountId(),
                        membership.getOrganizationId(),
                        membership.getRoleId()
                )).toList();
    }

    public void delete(UUID id) {
        if (!organizationRepository.existsById(id))
            throw new OrganizationNotFoundException(id);

        organizationRepository.deleteById(id);
    }
}
