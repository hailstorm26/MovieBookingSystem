import Movie.MovieHandler;
import User.AUser;
import User.UserHandler;
import Movie.*;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class MovieBookingSystem {

	private static UserHandler uh = UserHandler.getInstance();
    private static MovieHandler mh = MovieHandler.getInstance();

    public static void main(String[] args) {
    	testUser();
    	testAdmin();
        createMovieAndShowings("7:45pm", "Lubbock", "Black Adam", "In ancient Kahndaq, Teth Adam was bestowed the almighty powers of " +
                "the gods. After using these powers for vengeance, he was imprisoned, becoming Black Adam. Nearly 5,000 " +
                "years have passed, and Black Adam has gone from man to myth to legend. Now free, his unique form of justice," +
                " born out of rage, is challenged by modern-day heroes who form the Justice Society: Hawkman, Dr. Fate, " +
                "Atom Smasher and Cyclone.", 7.50, "src/main/java/black adam.png");
        createMovieAndShowings("8:00pm", "Lubbock", "The Menu", "The film, penned by Will " +
                "Tracy and Seth Reiss, focuses on a young couple who visits an exclusive destination restaurant on a " +
                "remote island where the acclaimed chef has prepared a lavish tasting menu, along with some shocking " +
                "surprise.Deadline notes,Fiennes plays the world-class chef who sets it all up and adds some unexpected" +
                " ingredients to the menu planned. The action follows one particular A-list couple that takes part. " +
                "I've heard Stone will play half of that couple.",7.50, "src/main/java/the menu.png");
        createMovieAndShowings("8:00pm", "Lubbock", "Top Gun: Maverick", "After more " +
                "than 30 years of service as one of the Navy's top aviators, Pete \"Maverick\" Mitchell is where he " +
                "belongs, pushing the envelope as a courageous test pilot and dodging the advancement in rank that " +
                "would ground him. Training a detachment of graduates for a special assignment, Maverick must confront " +
                "the ghosts of his past and his deepest fears, culminating in a mission that demands the ultimate " +
                "sacrifice from those who choose to fly it.", 7.50, "src/main/java/top gun maverick.png");
    	GUI gui = new GUI();
    	gui.start();
    	
    }
    
    public static AUser getUser() {
        return uh.getUser();
    }
	

    public static void testUser() {
    	uh.create("Hailey", "user", "123-456-7890", "123 Address St., Lubbock", "pw1", false);
    }
    
    public static void testAdmin() {
    	uh.create("Admin", "admin", "555-123-4567", "456 Fakeplace Rd., Lubbock", "pw2", true);
    }

    public static void createMovieAndShowings(String showingTime, String theater, String title, String description, double price, String image) {
        HashMap<String, List<String>> ourShowings = new HashMap<String, List<String>>();
        List<String> showingTimes = new ArrayList<>();
        showingTimes.add(0, showingTime);
        ourShowings.put(theater, showingTimes);


        Movie mov = mh.createMovie(title, description, price, ourShowings, image);
        mh.addMovie(mov);



    }


}
