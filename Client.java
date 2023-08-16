package Tomorrowland;

public class Client {
    private String name;
    private int dpi;
    public int ticket = 0;
    public double budg;


    public Client(String name, int dpi, int ticket, double budg){
        this.name = name;
        this.dpi = dpi;
        this.ticket = ticket;
        this.budg = budg;
    }

    public int getTicket(){
        return ticket;
    }
}
