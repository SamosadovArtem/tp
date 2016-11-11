package com.ticket.models;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;

/**
 * Created by Admin on 27.07.2016.
 */
@Entity
@Table(name = "ticket")
public class Ticket extends AbstractEntity {

    private Event event;
    private BigDecimal cost;
    private int seller;
    private Integer buyer;

    private String details;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    @PrimaryKeyJoinColumn(name = "event")
    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Basic
    @Column(name = "cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "seller")
    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    @Basic
    @Column(name = "buyer")
    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    @Basic
    @Column(name = "details")
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Transient
    public boolean isAvailable(){
        return buyer == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket that = (Ticket) o;

        if (id != that.id) return false;
        if (event != that.event) return false;
        if (cost != that.cost) return false;
        if (seller != that.seller) return false;
        if (buyer != null ? !buyer.equals(that.buyer) : that.buyer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + event.getId();
        temp = Double.doubleToLongBits(31);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + seller;
        result = 31 * result + (buyer != null ? buyer.hashCode() : 0);
        return result;
    }
}
