package com.ticket.repository;

import com.ticket.models.Role;

/**
 * Repository for {@link Role} entity
 * extends {@link CRUDRepository}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public interface RoleRepository extends CRUDRepository<Role> {

    Role findByRoleName(String roleName);

}
