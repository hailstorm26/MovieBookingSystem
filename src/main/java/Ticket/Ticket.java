package Ticket;

//import lombok.Builder;
//import lombok.Data;

//@Data @Builder
public class Ticket {
   
	private String dateTime;
    private String theater;
    private int id; // seat number
    private double price;

    protected Ticket(String dateTime, String theater, int id, double price) {
    	dateTime = this.dateTime;
    	theater = this.theater;
    	id = this.id;
    	price = this.price;
	}
    
}
