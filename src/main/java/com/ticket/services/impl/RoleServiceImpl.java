package com.ticket.services.impl;

import com.ticket.models.Role;
import com.ticket.repository.RoleRepository;
import com.ticket.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementation of {@link RoleService}
 *
 * @author Artem Samosadov
 * @version 1.0
 */

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    @Transactional
    public Role findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    @Transactional
    public Role findByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }
}
