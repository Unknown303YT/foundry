package com.riverstone.unknown303.foundry.server.organization;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/organizations")
public class OrganizationController {
    private final OrganizationService service;

    public OrganizationController(OrganizationService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Organization create(
            @RequestParam UUID creatorId,
            @Valid @RequestBody CreateOrganizationRequest request
    ) {
        return service.create(creatorId, request.name());
    }

    @GetMapping("/{id}")
    public Organization findById(@PathVariable UUID id) {
        return service.findById(id);
    }

    @GetMapping
    public List<Organization> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable UUID id) {
        service.delete(id);
    }
}
