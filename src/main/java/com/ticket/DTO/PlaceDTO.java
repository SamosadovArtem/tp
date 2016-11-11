package com.ticket.DTO;

/**
 * DTO for {@link com.ticket.models.Place}
 * extends {@link AbstractDTO}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public class PlaceDTO extends AbstractDTO {

    private int city;

    private String title;

    public int getCity() {
        return city;
    }

    public void setCity(int city) {
        this.city = city;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
