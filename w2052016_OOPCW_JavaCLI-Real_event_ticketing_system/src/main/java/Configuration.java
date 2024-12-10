import com.google.gson.Gson;

import java.io.*;
import java.util.Scanner;


class Configuration {
    private int totalTickets;
    private int ticketReleaseRate;
    private int customerRetrievalRate;
    private int maxTicketCapacity;

    public Configuration(int totalTickets,int ticketReleaseRate, int customerRetrievalRate, int maxTicketCapacity){
        this.totalTickets=totalTickets;
        this.ticketReleaseRate=ticketReleaseRate;
        this.customerRetrievalRate=customerRetrievalRate;
        this.maxTicketCapacity=maxTicketCapacity;
    }
    public Configuration(){}

    public int getTotalTickets(){
        return totalTickets;
    }
    public void setTotalTickets(int totalTickets){
        this.totalTickets=totalTickets;
    }
    public int getTicketReleaseRate(){
        return ticketReleaseRate;
    }
    public void setTicketReleaseRate(int ticketReleaseRate){
        this.ticketReleaseRate=ticketReleaseRate;
    }
    public int getCustomerRetrievalRate(){
        return customerRetrievalRate;
    }
    public void setCustomerRetrievalRate(int customerRetrievalRate){
        this.customerRetrievalRate=customerRetrievalRate;
    }
    public int getMaxTicketCapacity(){
        return maxTicketCapacity;
    }
    public void setMaxTicketCapacity(int maxTicketCapacity){
        this.maxTicketCapacity=maxTicketCapacity;
    }
    public void configureSystem(){
        Scanner scanner=new Scanner(System.in);

        Logger.log("Starting system configuration...");
        System.out.println("\nConfigure the Ticketing System;");

        System.out.print("Enter total tickets(must > 0): ");
        totalTickets=getValidPositiveInteger(scanner);

        System.out.print("Enter ticket release rate(must>0): ");
        ticketReleaseRate=getValidPositiveInteger(scanner);

        System.out.print("Enter customer retrieval rate(must>0): ");
        customerRetrievalRate=getValidPositiveInteger(scanner);

        System.out.print("Enter max ticket capacity(must>0): ");
        maxTicketCapacity=getValidMaxCapacity(scanner, totalTickets);

        Logger.log("Configuration completed: \nTotal Tickets= "+totalTickets+", \nTicket Release Rate= "+ticketReleaseRate+", \n Customer Retrieval Rate= "+
                customerRetrievalRate+",\nMax Capacity= "+maxTicketCapacity);
    }
    private int getValidPositiveInteger(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                int value = Integer.parseInt(input);

                if (value > 0) {
                    return value;
                } else {
                    System.out.print("Invalid input. Please enter a positive integer: ");
                }
            } catch (NumberFormatException e) {
                Logger.log("Invalid input (not an integer): " + e.getMessage());
                System.out.print("Invalid input. Please enter a positive integer: ");
            }
        }
    }
    private int getValidMaxCapacity(Scanner scanner, int minCapacity){
        while(true){
            try{
                String input=scanner.nextLine().trim();
                int value=Integer.parseInt(input);

                if(value>minCapacity){
                    return value;
                }else{
                    System.out.print("Invalid input. Please enter a value greater than "+minCapacity+": ");
                }
            }catch (NumberFormatException e){
                Logger.log("Invalid input for max capacity(not an integer): "+e.getMessage());
                System.out.print("Invalid input. Please enter a positive integer greater than "+minCapacity+": ");
            }
        }
    }
    public void saveToJSONFile(String fileName){
        Gson gson =new Gson();
        try(FileWriter writer=new FileWriter(fileName)){
            gson.toJson(this,writer);
            Logger.log("Configuration saved to JSON file: "+fileName);
        }catch (IOException e){
            Logger.log("Error saving configuration to JSON file: "+e.getMessage());
        }
    }
    public static Configuration loadFromJSONFile(String fileName){
        Gson gson=new Gson();
        try(FileReader reader=new FileReader(fileName)){
            Logger.log("Loading configuration from JSON file: "+fileName);
            return gson.fromJson(reader,Configuration.class);
        }catch (IOException e){
            Logger.log("Error loading configuration from JSON file: "+e.getMessage());
            return null;
        }
    }
    public void saveToTextFile(String fileName){
        try(BufferedWriter writer=new BufferedWriter(new FileWriter(fileName))){
            writer.write("Total Tickets= "+totalTickets+"\n");
            writer.write("Ticket Release Rate= "+ticketReleaseRate+"\n");
            writer.write("Customer Retrieval Rate= "+customerRetrievalRate+"\n");
            writer.write("Max Ticket Capacity= "+maxTicketCapacity+"\n");
            Logger.log("Configuration saved to text file: "+fileName);
        }catch (IOException e){
            Logger.log("Error saving configuration to text file: "+e.getMessage());
        }
    }
    public static Configuration loadFromTextFile(String fileName){
        try (BufferedReader reader=new BufferedReader(new FileReader(fileName))){
            int totalTickets=Integer.parseInt(reader.readLine().split("=")[1]);
            int ticketReleaseRate=Integer.parseInt(reader.readLine().split("=")[1]);
            int customerRetrievalRate=Integer.parseInt(reader.readLine().split("=")[1]);
            int maxTicketCapacity=Integer.parseInt(reader.readLine().split("=")[1]);
            Logger.log("Loaded configuration from text file: "+fileName);
            return new Configuration(totalTickets,ticketReleaseRate,customerRetrievalRate,maxTicketCapacity);
        }catch (IOException | NumberFormatException e){
            Logger.log("Error loading configuration from text file: "+e.getMessage());
            return null;
        }
    }
}
