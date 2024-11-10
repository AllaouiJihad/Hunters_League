package org.jihad.hunters_leagues.repository;

import org.jihad.hunters_leagues.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);

    boolean existsByCin(String cin);

    Optional<User> findByCin(String cin);
    @Query("SELECT u FROM User u WHERE "
            + "(:username IS NULL OR :username = '' OR LOWER(u.username) LIKE LOWER(CONCAT(:username, '%'))) "
            + "AND (:email IS NULL OR :email = '' OR LOWER(u.email) LIKE LOWER(CONCAT(:email, '%')))")
    Page<User> search(@Param("username") String username, @Param("email") String email, Pageable pageable);

    Page<User> findAll(Pageable pageable);

    @Procedure(name = "DeleteUserWithDependencies")
    void deleteUserWithDependencies(@Param("id") UUID id);

    @Procedure(name = "DeleteUser")
    void deleteUser(@Param("id") UUID id);


}
