package com.ticket.services;

import com.ticket.models.Role;

/**
 * Service for {@link Role}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public interface RoleService {

    Role findById(int id);

    Role findByRoleName(String roleName);

}
