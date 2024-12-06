public class Main {
    public static void main(String[] args){
        Configuration config=TicketConfiguration.configurationSystem();
        TicketPool ticketPool=new TicketPool(config.getMaxTicketCapacity());

        Thread vendor1=new Thread(new TicketVendor(ticketPool, config.getTicketReleaseRate()));
        Thread customer1=new Thread(new Customer(ticketPool, config.getCustomerRetrievalRate()));

        vendor1.start();
        customer1.start();
    }
}

