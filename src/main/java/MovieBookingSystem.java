import User.AUser;
import User.UserHandler;

public class MovieBookingSystem {

	private static UserHandler uh = UserHandler.getInstance();

    public static void main(String[] args) {
    	testUser();
    	testAdmin();
    	
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

}
