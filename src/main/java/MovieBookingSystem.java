import User.AUser;
import User.UserHandler;

public class MovieBookingSystem {

//	private static AUser user = null;
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
    	uh.create("Hailey", "user@gmail.com", "123-456-7890", "123 Address St., Lubbock", "password1", false);
    }
    
    public static void testAdmin() {
    	uh.create("Admin", "admin", "555-123-4567", "456 Fakeplace Rd., Lubbock", "password2", true);
    }

}


//public static void setUser(AUser user) {
//MovieBookingSystem.user = user;
//}
//
