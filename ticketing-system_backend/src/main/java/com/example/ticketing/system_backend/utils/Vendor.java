package com.example.ticketing.system_backend.utils;

import com.example.ticketing.system_backend.model.TicketPool;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int releaseRate;

    //constructor to initialize the ticket pool and release rate
    public Vendor(TicketPool ticketPool, int releaseRate) {
        this.ticketPool = ticketPool;
        this.releaseRate = releaseRate;
    }

    @Override
    public void run() {
        while (true) {
            ticketPool.addTickets(releaseRate);//add tickets to the pool
            try {
                Thread.sleep(1000);//wait for 1 second before releasing more tickets
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();//restore interrupted status
            }
        }
    }
}
