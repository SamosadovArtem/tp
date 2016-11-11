package com.ticket.DTO;

/**
 * DTO for {@link com.ticket.models.EventType}
 * extends {@link AbstractDTO}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public class EventTypeDTO extends AbstractDTO{

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
