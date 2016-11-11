package com.ticket.validator;

import com.ticket.DTO.UserDTO;
import com.ticket.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *  Validator for {@link com.ticket.models.User} class
 *  implements {@link Validator} interface
 *
 *  @author Artem Samosadov
 *  @version 1.0
 */

@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserDTO user = (UserDTO)target;

        if(userService.findByUsername(user.getName()) != null){
            errors.rejectValue("name", "userForm.error.duplicatedName");
        }

        if (userService.findByEmail(user.getEmail()) != null){
            errors.rejectValue("email", "userForm.error.duplicatedEmail");
        }

        if (!user.getPassword().equals(user.getConfirmPassword())){
            errors.rejectValue("confirmPassword","userForm.error.confirmPassword");
        }

    }
}
