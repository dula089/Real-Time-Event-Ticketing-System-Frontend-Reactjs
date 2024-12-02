import java.util.Scanner;

class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public int getTotalTickets() {
        return totalTickets;
    }

    public int getTicketReleaseRate() {
        return ticketReleaseRate;
    }

    public int getCustomerRetrievalRate() {
        return customerRetrievalRate;
    }

    public int getMaxTicketCapacity() {
        return maxTicketCapacity;
    }

    public void setTotalTickets(int totalTickets) {
        this.totalTickets = totalTickets;
    }

    public void setTicketReleaseRate(int ticketReleaseRate) {
        this.ticketReleaseRate = ticketReleaseRate;
    }

    public void setCustomerRetrievalRate(int customerRetrievalRate) {
        this.customerRetrievalRate = customerRetrievalRate;
    }

    public void setMaxTicketCapacity(int maxTicketCapacity) {
        this.maxTicketCapacity = maxTicketCapacity;
    }

    public Configuration(int totalTickets, int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity) {
        this.totalTickets = totalTickets;
        this.ticketReleaseRate = ticketReleaseRate;
        this.customerRetrievalRate = customerRetrievalRate;
        this.maxTicketCapacity = maxTicketCapacity;
    }
}

public class TicketConfiguration{
    public static Configuration configurationSystem(){
            Scanner scanner = new Scanner(System.in);
            int totalTickets= 0, ticketReleaseRate = 0 , customerRetrievalRate = 0, maxTicketCapacity = 0;

            while(totalTickets <= 0){
                System.out.print("Enter Total Tickets(must be > 0): ");
                totalTickets = scanner.nextInt();
            }
            while(ticketReleaseRate<=0){
                System.out.print("Enter Ticket Release Rate(must be > 0): ");
                ticketReleaseRate = scanner.nextInt();
            }
            while(customerRetrievalRate<=0){
                System.out.print("Enter Customer Retrieval Rate(must be > 0): ");
                customerRetrievalRate = scanner.nextInt();
            }
            while(maxTicketCapacity<= totalTickets){
                System.out.print("Enter Max Ticket Capacity(must be > 0): ");
                maxTicketCapacity = scanner.nextInt();
            }
            scanner.close();
            return new Configuration(totalTickets, ticketReleaseRate, customerRetrievalRate, maxTicketCapacity);

    }

}