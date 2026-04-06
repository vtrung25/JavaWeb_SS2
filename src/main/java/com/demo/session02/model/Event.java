package com.demo.session02.model;

public class Event {
    private final Long id;
    private final String name;
    private final String eventDate;
    private final long price;
    private final int remainingTickets;

    public Event(Long id, String name, String eventDate, long price, int remainingTickets) {
        this.id = id;
        this.name = name;
        this.eventDate = eventDate;
        this.price = price;
        this.remainingTickets = remainingTickets;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEventDate() {
        return eventDate;
    }

    public long getPrice() {
        return price;
    }

    public int getRemainingTickets() {
        return remainingTickets;
    }
}

