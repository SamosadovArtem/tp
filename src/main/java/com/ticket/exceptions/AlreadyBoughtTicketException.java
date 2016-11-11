package com.ticket.exceptions;

/**
 * Created by Admin on 26.09.2016.
 */
public class AlreadyBoughtTicketException extends BusinessLogicException {

    public AlreadyBoughtTicketException(String message){
        super(message);
    }

}
