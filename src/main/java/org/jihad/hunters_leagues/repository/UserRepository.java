package org.jihad.hunters_leagues.repository;

import org.jihad.hunters_leagues.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    // Recherche par email
    Optional<User> findByEmail(String email);

    // Vérification d'existence par username
    boolean existsByUsername(String username);

    // Vérification d'existence par email
    boolean existsByEmail(String email);

    // Vérification d'existence par CIN
    boolean existsByCin(String cin);

    // Recherche par CIN
    Optional<User> findByCin(String cin);
}
