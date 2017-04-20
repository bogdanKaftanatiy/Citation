package com.kaftanatiy.citation.repository;

import com.kaftanatiy.citation.entity.User;

/**
 * Repository interface for User entity
 */
public interface UserRepository {
   User addUser(User user);

   User findOne(long id);
}
