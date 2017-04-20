package com.kaftanatiy.citation.repository;

import com.kaftanatiy.citation.entity.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Jpa implementation of user repository
 */
@Repository
@Transactional
public class JpaUserRepository implements UserRepository{
    private final static Logger logger = Logger.getLogger(JpaUserRepository.class);
    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    @Transactional
    public User addUser(User user) {
        logger.debug("Add user entity: " + user);
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        return user;
    }

    @Override
    public User findOne(long id) {
        User user = emf.createEntityManager().find(User.class, id);
        if (user == null)
            logger.warn("Do not find user with id = " + id);
        else
            logger.debug("Find user: " + user);
        return user;
    }

    @Override
    public User findOne(String username) {
        TypedQuery<User> query = emf.createEntityManager().
                createQuery("SELECT u FROM User u WHERE u.username=:usernameParam", User.class);
        query.setParameter("usernameParam", username);
        User relustUser = null;
        try {
            relustUser = query.getSingleResult();
        } catch (NoResultException e) {
            logger.error("User with username = '" + username + "' not found" + e);
            return null;
        }
        logger.debug("Find user with username: " + username);
        return relustUser;
    }

    @Override
    public List<User> getAll() {
        TypedQuery<User> query = emf.createEntityManager().createNamedQuery("User.getAll", User.class);
        List<User> result = query.getResultList();
        logger.debug("Get all users");
        return result;
    }
}
