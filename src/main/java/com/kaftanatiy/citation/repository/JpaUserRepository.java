package com.kaftanatiy.citation.repository;

import com.kaftanatiy.citation.entity.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.Transactional;

/**
 * Jpa implementation of user repository
 */
@Repository
@Transactional
public class JpaUserRepository implements UserRepository{
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public User addUser(User user) {
        return emf.createEntityManager().merge(user);
    }

    @Override
    public User findOne(long id) {
        return null;
    }
}
