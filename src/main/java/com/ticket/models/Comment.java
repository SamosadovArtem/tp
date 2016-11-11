package com.ticket.models;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by Admin on 27.07.2016.
 */
@Entity
@Table(name = "comment")
public class Comment extends AbstractEntity {

    private int event;
    private String username;
    private String text;
    private Date commentDate;


    @Basic
    @Column(name = "event")
    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Basic
    @Column(name = "user")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "text")
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Basic
    @Column(name = "commentDate")
    @Temporal(TemporalType.DATE)
    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Comment that = (Comment) o;

        if (id != that.id) return false;
        if (event != that.event) return false;
        if (username.equals(that.getUsername())) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + event;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        return result;
    }
}
