class Customer implements Runnable {
    private final TicketPool ticketPool;

    private final int retrievalRate;

    public Customer(TicketPool ticketPool,int retrievalRate){
        this.ticketPool= ticketPool;
        this.retrievalRate = retrievalRate;
    }
    @Override
    public  void run() {
        while(true){
            if(!ticketPool.removeTicket()){
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();
                }
            }
        }
    }
}
