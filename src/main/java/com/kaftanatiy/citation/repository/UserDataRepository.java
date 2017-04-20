package com.kaftanatiy.citation.repository;

import com.kaftanatiy.citation.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Spring Data interface for user repository
 */
public interface UserDataRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
