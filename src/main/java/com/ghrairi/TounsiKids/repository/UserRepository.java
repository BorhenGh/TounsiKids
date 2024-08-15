package com.ghrairi.TounsiKids.repository;

import com.ghrairi.TounsiKids.models.Enumeration.Role;
import com.ghrairi.TounsiKids.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface UserRepository extends JpaRepository<User, Long> {
    // Trouver tous les utilisateurs par rôle
    List<User> findByRoles(Role role);

    // Trouver un utilisateur par email
    Optional<User> findByEmail(String email);

    // Vérifier si un utilisateur existe par email
    boolean existsByEmail(String email);
}
