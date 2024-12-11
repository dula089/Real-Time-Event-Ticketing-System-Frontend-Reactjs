package com.example.ticketing.system_backend.utils;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketPool {
    private AtomicInteger ticketsAvailable;//Thread safe counter for tickets
    private final int maxCapacity;//maximum allowed tickets in the pool

    //constructor to initialize total tickets and max capacity
    public TicketPool(int totalTickets, int maxCapacity) {
        this.ticketsAvailable = new AtomicInteger(totalTickets);
        this.maxCapacity = maxCapacity;
    }

    //synchronized method to add tickets to the pool
    public synchronized void addTickets(int number) {
        if (ticketsAvailable.get() + number <= maxCapacity) {
            ticketsAvailable.addAndGet(number);
        } else {
            throw new IllegalStateException("Cannot add more tickets, max capacity reached.");
        }
    }

    //synchronized method to remove a ticket from the pool
    public synchronized boolean removeTicket() {
        if (ticketsAvailable.get() > 0) {
            ticketsAvailable.decrementAndGet();
            return true;
        } else {
            return false;
        }
    }

    //method to get the current number of available tickets
    public int getTicketsAvailable() {
        return ticketsAvailable.get();
    }
}
