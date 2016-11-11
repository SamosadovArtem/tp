package com.ticket.DTO;

import java.math.BigDecimal;

/**
 * DTO for {@link com.ticket.models.Ticket}
 * extends {@link AbstractDTO}
 *
 * @author Artem Samosadov
 * @version 1.0
 */
public class TicketDTO extends AbstractDTO{

    private int seller;

    private Integer buyer;

    private String details;

    private BigDecimal cost;

    private EventDTO event;

    public EventDTO getEvent() {
        return event;
    }

    public void setEvent(EventDTO event) {
        this.event = event;
    }

    public int getSeller() {
        return seller;
    }

    public void setSeller(int seller) {
        this.seller = seller;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getBuyer() {
        return buyer;
    }

    public void setBuyer(Integer buyer) {
        this.buyer = buyer;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
