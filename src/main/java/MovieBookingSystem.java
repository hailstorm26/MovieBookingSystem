import User.User;
import User.UserHandler;

public class MovieBookingSystem {

	private static User user = null;

    public static void main(String[] args) {
    	testUser();
    	testAdmin();
    	
    	GUI gui = new GUI();
    	gui.start();
    	
    }
    
    public static User getUser() {
        return user;
    }
	
    public static void setUser(User user) {
        MovieBookingSystem.user = user;
    }
	
    public static void testUser() {
    	UserHandler.getInstance().create("Hailey", "user@gmail.com", "123-456-7890", "123 Address St., Lubbock", "password1", false);
    }
    
    public static void testAdmin() {
    	UserHandler.getInstance().create("Admin", "admin", "555-123-4567", "456 Fakeplace Rd., Lubbock", "password2", true);
    }

}
