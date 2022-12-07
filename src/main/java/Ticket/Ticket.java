package Ticket;

import lombok.Builder;
import lombok.Data;

@Data @Builder
public class Ticket {
   
	private String dateTime;
    private String theater;
    private int seat; // seat number
    private double price;

    protected Ticket(String dateTime, String theater, int seat, double price) {
    	dateTime = this.dateTime;
    	theater = this.theater;
    	seat = this.seat;
    	price = this.price;
	}

    
}
