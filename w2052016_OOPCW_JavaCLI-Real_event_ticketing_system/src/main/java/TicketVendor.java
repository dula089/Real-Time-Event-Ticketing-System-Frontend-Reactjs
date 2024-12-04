class TicketVendor implements Runnable{
    private final TicketPool ticketPool;
    private final int ticketReleaseRate;

    public TicketVendor(TicketPool ticketPool, int ticketReleaseRate){
        this.ticketPool = ticketPool;
        this.ticketReleaseRate = ticketReleaseRate;
    }

    @Override
    public void run(){
        try{
            while(true){
                ticketPool.addTickets(ticketReleaseRate);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Vendor Interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
