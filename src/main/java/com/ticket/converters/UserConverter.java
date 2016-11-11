package com.ticket.converters;

import com.ticket.DTO.UserDTO;
import com.ticket.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Converter for {@link User} and {@link UserDTO} classes
 *
 *  @author Artem Samosadov
 *  @version 1.0
 */
@Component
public class UserConverter {

    @Autowired
    RoleConverter roleConverter;

    @Autowired
    EventConverter eventConverter;

    public User convertUserDTOToUserEntity(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setCity(userDTO.getCity());
        user.setPassword(userDTO.getPassword());
        user.setName(userDTO.getName());
        user.setEmail(userDTO.getEmail());
        user.setMoneyAccount(userDTO.getMoneyAccount());
        user.setBalance(userDTO.getBalance());
        return user;
    }


    public UserDTO convertUserEntityToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setCity(user.getCity());
        userDTO.setPassword(user.getPassword());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setMoneyAccount(user.getMoneyAccount());
        userDTO.setBalance(user.getBalance());
        return userDTO;

    }


    public List<UserDTO> convertEntityListToDTOList(List<User> entityList) {
        List<UserDTO> dtoList = entityList.stream().map(this::convertUserEntityToUserDTO)
                .collect(Collectors.toList());

        return dtoList;
    }


    public List<User> convertDTOListToEntityList(List<UserDTO> dtoList) {
        List<User> entityList = dtoList.stream().map(this::convertUserDTOToUserEntity)
                .collect(Collectors.toList());

        return entityList;
    }

}
