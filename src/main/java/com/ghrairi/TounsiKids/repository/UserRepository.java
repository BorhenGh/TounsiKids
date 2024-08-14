package com.ghrairi.TounsiKids.repository;

import com.ghrairi.TounsiKids.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByRoles_Name(String roleName);

    // Optionnel: Si tu veux obtenir un seul utilisateur avec un rôle spécifique
    Optional<User> findByRoles_NameAndUsername(String roleName, String username);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
}
