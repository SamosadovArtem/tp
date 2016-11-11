package com.ticket.DTO;

/**
 * DTO for {@link com.ticket.models.Event}
 * extends {@link AbstractDTO}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public class EventDTO extends AbstractDTO{

    private boolean confirmed;

    private int place;

    private String title;
    private String description;

    private EventTypeDTO eventType;

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EventTypeDTO getEventType() {
        return eventType;
    }

    public void setEventType(EventTypeDTO type) {
        this.eventType = type;
    }
}
