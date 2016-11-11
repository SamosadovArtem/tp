package com.ticket.DTO;

/**
 * DTO for {@link com.ticket.models.City}
 * extends {@link AbstractDTO}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public class CityDTO extends AbstractDTO{

    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
