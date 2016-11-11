package com.ticket.repository.impl;

import com.ticket.models.User;
import com.ticket.repository.UserRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

/**
 * Implementation of {@link UserRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class UserRepositoryImpl extends CRUDRepositoryImpl<User> implements UserRepository{

    @PersistenceContext
    private EntityManager em;

    public UserRepositoryImpl(){
        super(User.class);
    }

    @Override
    public User findByUsername(String username) {
        try {
            return em.createQuery("select u from User u where u.name = :name", User.class)
                    .setParameter("name", username)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }

    @Override
    public User findByEmail(String email) {
        try {
            return em.createQuery("select u from User u where u.email = :email", User.class)
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (NoResultException e){
            return null;
        }
    }
}
