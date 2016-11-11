package com.ticket.repository.impl;

import com.ticket.models.Role;
import com.ticket.repository.RoleRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Implementation of {@link RoleRepository}
 * extend {@link CRUDRepositoryImpl}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
@Repository
public class RoleRepositoryImpl extends CRUDRepositoryImpl<Role> implements RoleRepository {

    @PersistenceContext
    private EntityManager em;

    public RoleRepositoryImpl() {
        super(Role.class);
    }

    @Override
    public Role findByRoleName(String roleName) {
        return em.createQuery("select r from Role r where r.title = :title", Role.class)
                .setParameter("title", roleName)
                .getSingleResult();

    }
}
