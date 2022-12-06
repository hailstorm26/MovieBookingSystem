package User;

import java.util.HashMap;
import java.util.Map;

public class UserHandler {

	public Map<String, AUser> users = new HashMap<>(); // email - user
    private AUser AUser;
    public static UserHandler instance;

    public static UserHandler getInstance() {
        if (instance == null) {
            Class var0 = UserHandler.class;
            synchronized (var0) {
                if (instance == null) {
                    instance = new UserHandler();
                }
            }
        } 
        return instance;
    }

    public boolean create(String name, String email, String phoneNumber, String homeAddress, String password, boolean admin) {
        if (users.containsKey(email)) {
            return false;
        }
        if (admin) {
        	AdminUser adminUser = new AdminUser(name, email, phoneNumber, homeAddress, password);
            users.putIfAbsent(email, adminUser);
            System.out.println("username: " + email + "\npassword: " + adminUser.getPassword() + "\n");
        } else {
        	BasicUser user = new BasicUser(name, email, phoneNumber, homeAddress, password);
            users.putIfAbsent(email, user);
            System.out.println("username: " + email + "\npassword: " + user.getPassword() + "\n");
        }

        return true;
    }
    
    public boolean login(String email, String password) {
        if (!users.containsKey(email)) {
            return false;
        }
        if (!users.get(email).getPassword().equals(password)) {
            return false;
        }
        this.AUser = users.get(email);
        return true;
    }

    public boolean logout() {
        if (this.AUser != null) {
            this.AUser = null;
            return true;
        }
        return false;
    }

    public AUser getUser() {
        return this.AUser;
    }

}

