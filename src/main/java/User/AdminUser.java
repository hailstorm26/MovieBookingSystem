package User;

public class AdminUser extends User {

    public AdminUser(String name, String email, String phoneNumber, String homeAddress, String password) {
        super(name, email, phoneNumber, homeAddress, password);
    }

    public void isAdmin() {
        System.out.println("yes");
    }
}
