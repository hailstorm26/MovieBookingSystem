package User;

public class AdminUser extends AUser {

    public AdminUser(String name, String email, String phoneNumber, String homeAddress, String password) {
        super(name, email, phoneNumber, homeAddress, password);
    }

    public void isAdmin() {
        System.out.println("yes");
    }
	
//	 public AdminUser(String name, String email, String phoneNumber, String homeAddress, String password) {
//	        super.setName(name);
//	        super.setEmail(email);
//	        super.setPhoneNumber(phoneNumber);
//	        super.setHomeAddress(homeAddress);
//	        super.setPassword(password);
//	    }
//
//	    public void isAdmin() {
//	        System.out.println("yes");
//	    }
}
