package com.riverstone.unknown303.foundry.server.organization.member;

import com.riverstone.unknown303.foundry.server.account.Account;
import com.riverstone.unknown303.foundry.server.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface OrganizationMembershipRepository extends JpaRepository<OrganizationMembership, UUID> {
    boolean existsByAccountAndOrganization(
            Account account,
            Organization organization
    );

    Optional<OrganizationMembership> findByAccountAndOrganization(
            Account account,
            Organization organization
    );

    List<OrganizationMembership> findByOrganization(
            Organization organization
    );

    List<OrganizationMembership> findByAccount(
            Account account
    );
}
