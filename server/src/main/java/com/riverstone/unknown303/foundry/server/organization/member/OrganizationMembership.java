package com.riverstone.unknown303.foundry.server.organization.member;

import com.riverstone.unknown303.foundry.server.account.Account;
import com.riverstone.unknown303.foundry.server.organization.Organization;
import com.riverstone.unknown303.foundry.server.organization.role.OrganizationRole;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class OrganizationMembership {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Organization organization;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private OrganizationRole role;

    protected OrganizationMembership() {}

    public OrganizationMembership(UUID id, Account account, Organization organization, OrganizationRole role) {
        this.id = id;
        this.account = account;
        this.organization = organization;
        this.role = role;
    }

    public UUID getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Organization getOrganization() {
        return organization;
    }

    public OrganizationRole getRole() {
        return role;
    }
}
