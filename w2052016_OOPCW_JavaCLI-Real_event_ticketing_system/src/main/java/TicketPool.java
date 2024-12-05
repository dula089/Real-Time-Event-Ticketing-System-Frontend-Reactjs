import java.util.LinkedList;

class TicketPool {
    private final LinkedList<Integer>tickets=new LinkedList<>();
    private final int capacity;

    public TicketPool(int capacity){
        this.capacity=capacity;
    }

    public synchronized void addTickets(int count) throws InterruptedException{
        while(tickets.size()+ count> capacity){
            wait();
        }
        for(int i=0; i<count; i++){
            tickets.add(1);
        }
        System.out.println("Added "+count+" tickets. Total available: "+ tickets.size());
        notifyAll();
    }
    public synchronized  void removeTickets(int count) throws InterruptedException{
        while(tickets.size()<count){
            wait();
        }
        for(int i=0; i<count; i++){
            tickets.remove();
        }
        System.out.println("Removed "+count+" tickets. Remaining: "+tickets.size());
        notifyAll();
    }
}
