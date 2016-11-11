package com.ticket.exceptions;

import com.ticket.models.User;

/**
 * Created by Admin on 08.10.2016.
 */
public class NotEnoughMoneyOnBalanceException extends BusinessLogicException {

    private User user;

    public NotEnoughMoneyOnBalanceException(String message, User user){
        super(message);
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
