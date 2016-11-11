package com.ticket.services;

import com.ticket.models.User;

import java.math.BigDecimal;

/**
 * Service for {@link User} class
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public interface UserService {

    User findByUsername(String username);

    void save(User user);

    User findByEmail(String email);

    void update(User user);

    User getById(int userId);

    void addMoney(User user, BigDecimal money);

    void removeMoney(User user, BigDecimal money);
}
