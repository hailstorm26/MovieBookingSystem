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
        createMovieAndShowings();
    	
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

    public static void createMovieAndShowings() {
        HashMap<String, List<String>> ourShowings = new HashMap<String, List<String>>();
        List<String> showingTimes = new ArrayList<>();
        showingTimes.add(0, "5:00");
        ourShowings.put("Lubbock", showingTimes);

        String title = "Black Adam";

        Movie mov = mh.createMovie(title, "In ancient Kahndaq, Teth Adam was bestowed the almighty powers of " +
                "the gods. After using these powers for vengeance, he was imprisoned, becoming Black Adam. Nearly 5,000 " +
                "years have passed, and Black Adam has gone from man to myth to legend. Now free, his unique form of justice," +
                " born out of rage, is challenged by modern-day heroes who form the Justice Society: Hawkman, Dr. Fate, " +
                "Atom Smasher and Cyclone.", 7.50, ourShowings);
        mh.addMovie(mov);

//        for ( String key : ourShowings.keySet() ) {
//            for (String element : showingTimes) {
//                mh.addShowing(title, key, element);
//            }
//        }

    }


}
