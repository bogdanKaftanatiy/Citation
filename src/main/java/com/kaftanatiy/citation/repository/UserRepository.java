package com.kaftanatiy.citation.repository;

import com.kaftanatiy.citation.entity.User;

import java.util.List;

/**
 * Repository interface for User entity
 */
public interface UserRepository {
   User addUser(User user);

   User findOne(long id);

   User findOne(String username);

   List<User> getAll();
}
