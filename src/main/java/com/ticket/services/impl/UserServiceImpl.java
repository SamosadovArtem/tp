package com.ticket.services.impl;

import com.ticket.exceptions.NotEnoughMoneyOnBalanceException;
import com.ticket.locale.MessageService;
import com.ticket.models.Role;
import com.ticket.models.User;
import com.ticket.repository.UserRepository;
import com.ticket.services.RoleService;
import com.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of {@link UserService}
 *
 * @author Artem Samosadov
 * @version 1.0
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder bCryptPasswordEncoder;

    @Autowired
    private MessageService messageService;

    @Override
    @Transactional
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    @Transactional
    public void save(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));

        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByRoleName("ROLE_USER"));

        user.setRoles(roles);
        user.setBalance(BigDecimal.valueOf(100));

        userRepository.save(user);
    }

    @Override
    @Transactional
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void update(User user) {
        userRepository.update(user);
    }

    @Override
    @Transactional
    public User getById(int userId) {
        return userRepository.findById(userId);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void addMoney(User user, BigDecimal money) {

        user.setBalance(user.getBalance().add(money));

        userRepository.update(user);

    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public void removeMoney(User user, BigDecimal money) {

        if (user.getBalance().compareTo(money) == 1) {

            user.setBalance(user.getBalance().subtract(money));

            userRepository.update(user);

        } else {

            throw new NotEnoughMoneyOnBalanceException(
                    messageService.getMessage("ticket.exception.notEnoughMoney"),
                    user);
        }
    }
}
