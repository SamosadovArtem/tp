package com.ticket.converters;

import com.ticket.DTO.RoleDTO;
import com.ticket.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *  Converter for {@link com.ticket.models.Role} and {@link com.ticket.DTO.RoleDTO} classes
 *
 *  @author Artem Samosadov
 *  @version 1.0
 */
@Component
public class RoleConverter {

    @Autowired
    UserConverter userConverter;

    public Role convertRoleDTOToRoleEntity(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setTitle(roleDTO.getTitle());
        role.setUsers(userConverter.convertDTOListToEntityList(roleDTO.getUsers()));

        return role;
    }


    public RoleDTO convertRoleEntityToRoleDTO(Role roleEntity) {
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(roleEntity.getId());
        roleDTO.setTitle(roleEntity.getTitle());
        roleDTO.setUsers(userConverter.convertEntityListToDTOList(roleEntity.getUsers()));

        return roleDTO;
    }

    public List<RoleDTO> convertEntityListToDTOList(List<Role> entityList) {
        List<RoleDTO> dtoList = entityList.stream().map(this::convertRoleEntityToRoleDTO)
                .collect(Collectors.toList());
        return dtoList;
    }


    public List<Role> convertDTOListToEntityList(List<RoleDTO> dtoList) {
        if (dtoList != null){
            List<Role> entityList = dtoList.stream().map(this::convertRoleDTOToRoleEntity)
                    .collect(Collectors.toList());
            return entityList;
        } else {
            return new ArrayList<>();
        }

    }

}
