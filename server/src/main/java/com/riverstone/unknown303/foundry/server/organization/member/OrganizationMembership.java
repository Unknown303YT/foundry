package com.riverstone.unknown303.foundry.server.organization.member;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class OrganizationMembership {
    @Id
    private UUID id;

    private UUID accountId;

    private UUID organizationId;

    private UUID roleId;

    protected OrganizationMembership() {}

    public OrganizationMembership(UUID id, UUID accountId, UUID organizationId, UUID roleId) {
        this.id = id;
        this.accountId = accountId;
        this.organizationId = organizationId;
        this.roleId = roleId;
    }

    public UUID getId() {
        return id;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public UUID getOrganizationId() {
        return organizationId;
    }

    public UUID getRoleId() {
        return roleId;
    }
}
