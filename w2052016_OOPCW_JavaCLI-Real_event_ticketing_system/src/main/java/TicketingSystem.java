class TicketingSystem {
    private boolean running=false;
    private Configuration config;

    public TicketingSystem(Configuration config){
        this.config=config;
    }
    public void startSystem(){
        running=true;
        System.out.println("Ticketing System Started...");
    }
    public void stopSystem(){
        running=false;
        System.out.println("System stopped...");
    }
    public boolean isRunning(){
        return running;
    }
}
