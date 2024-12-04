class Customer implements Runnable {
    private final TicketPool ticketPool;
    private final int ticketRetrievalRate;

    public Customer(TicketPool ticketPool,int ticketRetrievalRate){
        this.ticketPool= ticketPool;
        this.ticketRetrievalRate = ticketRetrievalRate;
    }
    @Override
    public  void run(){
        try{
            while(true){
                ticketPool.removeTickets(ticketRetrievalRate);
                Thread.sleep(1000);
            }
        }catch (InterruptedException e){
            System.out.println("Customer interrupted.");
            Thread.currentThread().interrupt();
        }
    }
}
