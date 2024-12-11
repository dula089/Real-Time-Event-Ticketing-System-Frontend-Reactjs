package com.example.ticketing.system_backend.model;

import java.util.concurrent.atomic.AtomicInteger;

public class TicketPool {
    private AtomicInteger ticketsAvailable;
    private final int maxCapacity;

    public TicketPool(int totalTickets, int maxCapacity){
        this.ticketsAvailable=new AtomicInteger(totalTickets);
        this.maxCapacity=maxCapacity;
    }

    public synchronized void addTickets(int number){
        if (ticketsAvailable.get()+number<=maxCapacity){
            ticketsAvailable.addAndGet(number);
        }else{
            throw new IllegalStateException("Cannot add more tickets, max capacity reached.");
        }
    }
    public synchronized boolean removeTicket(){
        if(ticketsAvailable.get()>0){
            ticketsAvailable.decrementAndGet();
            return true;
        }else {
            return false;
        }
    }
    public int getTicketsAvailable(){
        return ticketsAvailable.get();
    }
}
