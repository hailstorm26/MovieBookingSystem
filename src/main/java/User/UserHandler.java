package User;

import java.util.HashMap;
import java.util.Map;

public class UserHandler {
    public Map<String, User> users = new HashMap<>(); // email - user
    private User AUser;
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
        User AUser = new AdminUser(name, email, phoneNumber, homeAddress, password);
        if (admin) {
            AdminUser adminUser = (AdminUser) AUser;
            users.putIfAbsent(email, adminUser);
        } else {
            BasicUser basicUser = (BasicUser) AUser;
            users.putIfAbsent(email, basicUser);
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

    public User getUser() {
        return this.AUser;
    }

}
