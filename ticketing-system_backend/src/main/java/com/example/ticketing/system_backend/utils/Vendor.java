package com.example.ticketing.system_backend.utils;

import com.example.ticketing.system_backend.model.TicketPool;

public class Vendor implements Runnable {
    private final TicketPool ticketPool;
    private final int releaseRate;

    public Vendor(TicketPool ticketPool,int releaseRate){
        this.ticketPool=ticketPool;
        this.releaseRate=releaseRate;
    }
    @Override
    public void run(){
        while (true){
            ticketPool.addTickets(releaseRate);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
    }
}
