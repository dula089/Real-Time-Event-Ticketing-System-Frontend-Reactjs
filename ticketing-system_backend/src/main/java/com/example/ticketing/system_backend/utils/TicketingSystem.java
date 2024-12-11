package com.example.ticketing.system_backend.utils;

import com.example.ticketing.system_backend.model.TicketPool;

public class TicketingSystem {
    private boolean running=false;
    private TicketPool ticketPool;

    public TicketingSystem(TicketPool ticketPool){
        this.ticketPool=ticketPool;
    }
    public void startSystem(){
        running=true;
        System.out.println("Ticketing System Started...");
        Thread vendorThread=new Thread(new Vendor(ticketPool,5));
        Thread customerThread=new Thread(new Customer(ticketPool,3));
        vendorThread.start();
        customerThread.start();
    }
    public void stopSystem(){
        running=false;
        System.out.println("System stopped...");
    }
    public boolean isRunning(){
        return running;
    }
}
