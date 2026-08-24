package com.riverstone.unknown303.foundry.server.account;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping
    public Account create(@RequestParam String username, @RequestParam String email) {
        return accountService.create(username, email);
    }

    @GetMapping
    public List<Account> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable UUID id) {
        return accountService.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable UUID id) {
        return accountService.delete(id);
    }
}
