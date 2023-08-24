package net.askkevin.askkevin.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("from User u where u.email = ?1")
    User findByEmail(String username);
}
