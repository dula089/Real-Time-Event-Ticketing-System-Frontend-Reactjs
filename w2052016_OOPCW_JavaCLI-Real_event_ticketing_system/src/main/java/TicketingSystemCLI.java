import java.util.Scanner;

public class TicketingSystemCLI {
    public static void main(String[] args){
        Logger.log("Ticketing system CLI started.");
        Scanner scanner=new Scanner(System.in);
        Configuration config=new Configuration(100,5,3,500);
        TicketingSystem system=new TicketingSystem(config);
        TicketPool ticketPool=null;

        while(true){
            try{
                System.out.println("\nWelcome to Real-Time-Event Ticketing System!");
                System.out.println("\nMenu");
                System.out.println("1.Configuration");
                System.out.println("2.Start the System");
                System.out.println("3.Stop the system");
                System.out.println("4.Save configuration to JSON file");
                System.out.println("5.Load configuration from JSON file");
                System.out.println("6.Save configuration to Text file");
                System.out.println("7.Load configuration from Text file");
                System.out.println("8.Exit");
                System.out.print("Enter your choice: ");
                int choice=Integer.parseInt(scanner.nextLine());

                switch (choice){
                    case 1:
                        config.configureSystem();
                        ticketPool=new TicketPool(config.getTotalTickets(), config.getMaxTicketCapacity());
                        Logger.log("System configured with "+config.getTotalTickets()+" tickets.");
                        break;

                    case 2:
                        if(ticketPool == null){
                            Logger.log("Attempted to start system without configuration.");
                            System.out.println("Please configure the system first.");
                        }else{
                            system.startSystem();
                            startVendorsAndCustomers(ticketPool,config);
                            Logger.log("System started.");
                        }
                        break;
                    case 3:
                        system.stopSystem();
                        Logger.log("System stopped.");
                        break;
                    case 4:
                        System.out.print("Enter filename to save configuration(JSON): ");
                        String jsonFilename=scanner.nextLine();
                        config.saveToJSONFile(jsonFilename);
                        break;
                    case 5:
                        System.out.print("Enter filename to load configuration(JSON): ");
                        String loadJsonFilename=scanner.nextLine();
                        Configuration loadedJsonConfig=Configuration.loadFromJSONFile(loadJsonFilename);
                        if(loadedJsonConfig!=null){
                            config=loadedJsonConfig;
                            Logger.log("Configuration loaded from JSON file: "+loadJsonFilename);

                        }break;
                    case 6:
                        System.out.print("Enter filename to save configuration(Text): ");
                        String textFilename=scanner.nextLine();
                        config.saveToTextFile(textFilename);
                        break;
                    case 7:
                        System.out.print("Enter filename to load configuration(Text): ");
                        String loadTextFilename=scanner.nextLine();
                        Configuration loadedTextConfig=Configuration.loadFromTextFile(loadTextFilename);
                        if(loadedTextConfig!=null){
                            config=loadedTextConfig;
                            Logger.log("Configuration loaded from Text file: "+loadTextFilename);
                        }break;
                    case 8:
                        Logger.log("Exiting system...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        Logger.log("Invalid menu choice: "+choice);
                }
            }catch (NumberFormatException e){
                Logger.log("Invalid input: "+e.getMessage());
                System.out.println("Please enter a valid number.");
            }
        }

    }
    private static void startVendorsAndCustomers(TicketPool ticketPool,Configuration config){
        Thread vendorThread=new Thread(new Vendor(ticketPool,config.getTicketReleaseRate()));
        Thread customerThread=new Thread(new Customer(ticketPool,config.getCustomerRetrievalRate()));
        vendorThread.start();
        customerThread.start();
        Logger.log("Vendors and Customers started.");
    }
}
