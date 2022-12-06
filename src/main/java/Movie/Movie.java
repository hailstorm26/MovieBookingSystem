package Movie;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Ticket.Ticket;
import User.AUser;

@Data @Builder
public class Movie {
    private String title;
    private String description;
    private double price;
    private int ticketsSold;
    private HashMap<String, List<String>> showings; // Theater location - List of Times
    public List<Review> reviews;

    protected Movie(String title, String description, double price, int ticketsSold, HashMap<String, List<String>> showings, List<Review> reviews) {
    	title = this.title;
    	description = this.description;
    	price = this.price;
    	ticketsSold = this.ticketsSold;
    	showings = this.showings;
    	reviews = this.reviews;
    }
    
    protected void addShowing(String theater, String time) {
        if (!showings.containsKey(theater)) {
            List<String> times = new ArrayList<>();
            times.add(time);
            showings.put(theater, times);
        } else {
            showings.get(theater).add(time);
        }
    }

    protected void addReview(Review review) {
        reviews.add(review);
    }

	public HashMap<String, List<String>> getShowings() {
		return showings;
	}

	public void setTicketsSold(int i) {
		this.ticketsSold = i;
	}
	
	public int getTicketsSold() {
		return ticketsSold;
	}

	protected List<Review> getReviews() {
		return reviews;
	}
	
}
