import java.util.concurrent.atomic.AtomicInteger;

class TicketPool{
    private AtomicInteger ticketsAvailable;
    private final int maxCapacity;

    public TicketPool(int totalTickets,int maxCapacity){
        this.ticketsAvailable=new AtomicInteger(totalTickets);
        this.maxCapacity=maxCapacity;
    }
    public synchronized void addTickets(int number){
        if(ticketsAvailable.get()+number<=maxCapacity){
            ticketsAvailable.addAndGet(number);
            Logger.log(number+" tickets added. Tickets available: "+ ticketsAvailable.get());
        }else{
            Logger.log("cannot add more tickets, max capacity reached.");
        }
    }
    public synchronized boolean removeTicket(){
        if(ticketsAvailable.get()>0){
            ticketsAvailable.decrementAndGet();
            Logger.log("1 ticket removed. Tickets available: "+ticketsAvailable.get());
            return true;
        }else{
            Logger.log("No tickets available for purchase.");
            return false;
        }
    }
    public int getTicketsAvailable(){
        return ticketsAvailable.get();
    }
}
