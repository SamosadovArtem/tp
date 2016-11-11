package com.ticket.repository;

import com.ticket.models.User;

/**
 * Created by Admin on 27.07.2016.
 */
public interface UserRepository extends CRUDRepository<User> {

    User findByUsername(String username);

    User findByEmail(String email);

}
