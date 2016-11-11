package com.ticket.DTO;

import java.util.List;

/**
 * DTO for {@link com.ticket.models.Role}
 * extends {@link AbstractDTO}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public class RoleDTO extends AbstractDTO {

    private String title;

    private List<UserDTO> users;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }
}
