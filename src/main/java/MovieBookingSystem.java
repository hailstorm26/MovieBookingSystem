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
        createMovieAndShowings("7:45pm", "Lubbock", "Black Adam", "In ancient Kahndaq, " +
                "Teth Adam was bestowed the almighty powers of " +
                "the gods. After using these powers for vengeance, he was imprisoned, becoming Black Adam. Nearly 5,000 " +
                "years have passed, and Black Adam has gone from man to myth to legend. Now free, his unique form of justice," +
                " born out of rage, is challenged by modern-day heroes who form the Justice Society: Hawkman, Dr. Fate, " +
                "Atom Smasher and Cyclone.", 7.50, "src/main/java/black adam.png", "Dwayne Johnson," +
                " Aldis Hodge, Pierce Brosnan", "2h 5m");
        createMovieAndShowings("8:00pm", "Lubbock", "The Menu", "The film, penned by Will " +
                "Tracy and Seth Reiss, focuses on a young couple who visits an exclusive destination restaurant on a " +
                "remote island where the acclaimed chef has prepared a lavish tasting menu, along with some shocking " +
                "surprise.Deadline notes,Fiennes plays the world-class chef who sets it all up and adds some unexpected" +
                " ingredients to the menu planned. The action follows one particular A-list couple that takes part. " +
                "I've heard Stone will play half of that couple.",7.50, "src/main/java/the menu.png",
                "Ralph Fiennes, Anya Taylor-Joy, Nicholas Hoult", "1h 47m");
        createMovieAndShowings("8:25pm", "Lubbock", "Top Gun: Maverick", "After more " +
                "than 30 years of service as one of the Navy's top aviators, Pete \"Maverick\" Mitchell is where he " +
                "belongs, pushing the envelope as a courageous test pilot and dodging the advancement in rank that " +
                "would ground him. Training a detachment of graduates for a special assignment, Maverick must confront " +
                "the ghosts of his past and his deepest fears, culminating in a mission that demands the ultimate " +
                "sacrifice from those who choose to fly it.", 7.50, "src/main/java/top gun 2.png",
                "Tom Cruise, jennifer Connelly, Miles Teller", "2h 10m");
    	createMovieAndShowings("8:45pm", "Lubbock", "Interstellar", "In Earth's " +
                "future, a global crop blight and second Dust Bowl are slowly rendering the planet uninhabitable. " +
                "Professor Brand (Michael Caine), a brilliant NASA physicist, is working on plans to save mankind " +
                "by transporting Earth's population to a new home via a wormhole. But first, Brand must send " +
                "former NASA pilot Cooper (Matthew McConaughey) and a team of researchers through the wormhole " +
                "and across the galaxy to find out which of three planets could be mankind's new home.",
                7.50, "src/main/java/interstellar.png", "Matthew McConaughey, Anne Hathaway, Jessica Chastain",
                "2h 49m");
        createMovieAndShowings("9:00pm", "Lubbock", "Inception", "Dom Cobb " +
                "(Leonardo DiCaprio) is a thief with the rare ability to enter people's dreams and steal " +
                "their secrets from their subconscious. His skill has made him a hot commodity in the world " +
                "of corporate espionage but has also cost him everything he loves. Cobb gets a chance at " +
                "redemption when he is offered a seemingly impossible task: Plant an idea in someone's " +
                "mind. If he succeeds, it will be the perfect crime, but a dangerous enemy anticipates " +
                "Cobb's every move.",7.50, "src/main/java/inception.png","Leonardo DiCaprio, " +
                "Joseph Gordon-Levitt, and Elliot Page", "2h 28m");
        createMovieAndShowings("2:00pm", "Lubbock", "Elf","Buddy (Will Ferrell) was " +
                "accidentally transported to the North Pole as a toddler and raised to adulthood among Santa's elves. " +
                "Unable to shake the feeling that he doesn't fit in, the adult Buddy travels to New York, in full elf " +
                "uniform, in search of his real father. As it happens, this is Walter Hobbs (James Caan), a cynical " +
                "businessman. After a DNA test proves this, Walter reluctantly attempts to start a relationship with " +
                "the childlike Buddy with increasingly chaotic results",7.50, "src/main/java/elf2.png",
                "Will Ferrell, James Caan, Bob Newhart","1h 37m");
        createMovieAndShowings("3:15pm", "Lubbock", "Polar Express","Polar Express," +
                " an inspiring adventure based on the beloved children's book by Chris Van Allsburg. " +
                "When a doubting young boy takes an extraordinary train ride to the North Pole, he embarks on a journey" +
                " of self-discovery that shows him that the wonder of life never fades for those who believe.",7.50,
                "src/main/java/polar express.png", "Tom Hanks, Chris Coppola, Michael Jeter", "1h 40m");
        createMovieAndShowings("8:10pm", "Lubbock", "Guardians of the Galaxy vol 3","Still" +
                " reeling from the loss of Gamora, Peter Quill rallies his team to defend the universe and one of their " +
                "own - a mission that could mean the end of the Guardians if not successful.",7.50,
                "src/main/java/guardians of the galaxy vol 3.png", "Chris Pratt, Zoe Saldana, Dave Bautista", "");
        createMovieAndShowings("9:40pm", "Lubbock", "John Wick: Chapter 4","With the" +
                " price on his head ever increasing, legendary hit man John Wick takes his fight against the High Table" +
                " global as he seeks out the most powerful players in the underworld, from New York to Paris to Japan" +
                " to Berlin.",7.50, "src/main/java/john wick.png", "Keanu Reeves, Donnie Yen, Bill Skarsgard","");
        createMovieAndShowings("7:20pm", "Lubbock", "Avatar: The Way of Water","Jake" +
                " Sully and Ney'tiri have formed a family and are doing everything to stay together. However, they must" +
                " leave their home and explore the regions of Pandora. When an ancient threat resurfaces, Jake must fight" +
                " a difficult war against the humans.",7.50, "src/main/java/avatar2.png",
                "Zoe Saldana, Sam Worthington, Kate Winslet","3h 12m");
//        createReviews("Avatar", 5,"Fantastic movie!","This incredible movie is a work of genius on every level. Flawless script, Pandora's hauntingly beautiful scenery, seamless technology and of course engaging characters and acting. You are watching A -1 entertainment, but much more than that as you realize that this interwoven tale on another pristine planet, which earthlings are trying to dominate, parallels what we have done to a once pristine North America, the aboriginal  population, Africa and much of her peoples and the Amazon rain forest etc." );
//        createReviews("Avatar",2,"best movie ever", "What a daring dream it is, to combine the finest qualities of humanity with these marvelous creatures. I always turn to this film when I'm feeling out of sorts, and am always happy to gaze upon the visage of dear, sweet Neytiri. Oh, if only I were the one who could have overcome his paralysis on an alien adventure planet to become her boyfriend, instead of that other guy. Then she could have shown me how to be bold and courageous, and stand up to fight for your people, and maybe later, engage in a bizarre extraterrestrial reproductive process involving ponytails, and a magical tree I guess? But seriously, this is brilliant. I say, perhaps there is no other movie that comes near the realm of limitless wonder that this one does. Land sakes alive this is a great movie.");
//        createReviews("Black Adam", 5, "A masterpiece ", "This movie is by no accounts a masterpiece, but it is an incredibly fun and surprisingly funny film that has a shockingly nuanced theme about heroism and morality being relative to one's own power to enforce it. I watched this movie alone and actually laughed out loud in the theaters a few times. The pacing is fun, the special effects are immersive, and all the characters are lovable. The corniness of some moments is pretty tongue-in-cheek and self-aware so it doesn't become cringey. If you want a fun movie to watch alone or with friends, Black Adam is it.");
//        createReviews("Black Adam", 4,"","");
//        createReviews("", ,"Not bad!","");
//        createReviews();
//        createReviews();



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

    public static void createMovieAndShowings(String showingTime, String theater, String title, String description, double price, String image, String cast, String runtime) {
        HashMap<String, List<String>> ourShowings = new HashMap<String, List<String>>();
        List<String> showingTimes = new ArrayList<>();
        showingTimes.add(0, showingTime);
        ourShowings.put(theater, showingTimes);

        Movie mov = mh.createMovie(title, description, price, ourShowings, image, cast, runtime);
        mh.addMovie(mov);

    }
    public static void createReviews(String title, double rating, String header, String review) {
        mh.addReview(title,rating,header,review);
    }


}
