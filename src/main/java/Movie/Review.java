package Movie;

//import lombok.Builder;
//import lombok.Data;

//@Data @Builder
public class Review {
    private double rating;
    private String header;
    private String reviewer;
    private String review;
    
    protected Review(double rating, String header, String reviewer, String review) {
    	rating = this.rating;
    	header = this.header;
    	reviewer = this.reviewer;
    	review = this.review;
    }
}
