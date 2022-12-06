package Movie;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Data @Builder
public class Movie {
    private String title;
    private String description;
    private double price;
    private int ticketsSold;
    private HashMap<String, List<String>> showings; // Theater location - List of Times
    public List<Review> reviews;

    protected Movie(String title, String description, double price, int ticketsSold, HashMap<String, List<String>> showings, List<Review> reviews) {
    	this.title = title;
    	this.description = description;
    	this.price = price;
    	this.ticketsSold = ticketsSold;
    	this.showings = showings;
    	this.reviews = reviews;
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
