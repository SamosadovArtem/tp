package com.ticket.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import javax.persistence.CascadeType;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by Admin on 27.07.2016.
 */
@Entity
@Table(name = "event")
public class Event extends AbstractEntity {

    private String title;
    private String description;

    private boolean confirmed;
    private int place;

    private EventType eventType;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @PrimaryKeyJoinColumn(name = "eventType")
    public EventType getEventType() {
        return eventType;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "confirmed")
    public boolean getConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    @Basic
    @Column(name = "place")
    public int getPlace() {
        return place;
    }

    public void setPlace(int place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Event that = (Event) o;

        if (id != that.id) return false;
        if (eventType != that.eventType) return false;
        if (confirmed != that.confirmed) return false;
        if (place != that.place) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + eventType.getId();
        result = 31 * result + place;
        return result;
    }
}
