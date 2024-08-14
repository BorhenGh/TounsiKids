package com.ghrairi.TounsiKids.models;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.util.Set;

public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Nom du rôle, par exemple "ROLE_ADMIN", "ROLE_USER", etc.

    @ManyToMany(mappedBy = "roles")
    private Set<User> users;
}
