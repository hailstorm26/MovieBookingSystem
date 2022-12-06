import User.UserHandler;

import javax.swing.*;

public class GUI {
	
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	
	JTextField name = new JTextField();
	JTextField emailAddr = new JTextField();
	JTextField phoneNumber = new JTextField();
	JTextField address = new JTextField();
	
	public void start() {
		System.out.println("\nstarting GUI\n");
		if (MovieBookingSystem.getUser() == null ) {
			System.out.println("inside condition");
            
			String choice = loginOrSignup();

            switch (choice) {
                case "Log in" -> login();
                case "Sign up" -> adminOrUser();
            }
        } else {
            while(MovieBookingSystem.getUser() != null) {
                loggedInUser();
            	//check if user or admin
            }
        }
	}

	
	private String loginOrSignup() {
		System.out.println("log in or sign up");
		String[] menu = {"Log in", "Sign up", ""};

        return (String) JOptionPane.showInputDialog(
                null,
                "Select an Option: ",
                "Select an Option",
                JOptionPane.QUESTION_MESSAGE,
                null,
                menu,
                menu[2]);
	}
	

	private void login() {
		//get username and password
		Object[] userInput = {
				"Username: ", username,
				"Password: ", password,
		};
		
		JOptionPane.showConfirmDialog(null, userInput, "Log in", JOptionPane.OK_CANCEL_OPTION);
		String uname = username.getText();
		String pw = password.getText();
		
		//log in admin or user if credentials are correct
		if(UserHandler.getInstance().login(uname,pw) == true) {
			if(MovieBookingSystem.getUser().getName().equalsIgnoreCase("admin")) {
				loggedInAdmin();
			}
			else {
				loggedInUser();
			}
		}
		else {
			System.out.println("Incorrect username or password");
			login();
		}
	}
	
	private void adminOrUser() {
		String[] menu = {"User Account", "Admin Account", ""};

        String choice = (String) JOptionPane.showInputDialog(
                null,
                "Select an Option: ",
                "Select an Option",
                JOptionPane.QUESTION_MESSAGE,
                null,
                menu,
                menu[2]);

        switch (choice) {
            case "User Account" -> createUser();
            case "Admin Account" -> createAdmin();
        }
	}


	private void createUser() {
		//get input
		Object[] userInput =  {
				"Name: ", name,
				"Email: ", emailAddr,
				"Phone number: ", phoneNumber,
				"Home address: ", address,
				"Password: ", password
		};
		
		
		JOptionPane.showConfirmDialog(null, userInput, "Sign up", JOptionPane.OK_CANCEL_OPTION);
		String nm = name.getText();
		String email = emailAddr.getText();
		String phone = phoneNumber.getText();
		String addy = address.getText();
		String pw = password.getText();
		System.out.println("successfully created an Account as user");
		loggedInUser();
		
		//create user account using UserHandler method
		//...
		
	}
	
	private void createAdmin() {
		//get input
		//create admin account using UserHandler method
	}

	private void loggedInUser() {
		System.out.println("successfully logged in as user");
		
		String[] menu = {"Search movies", "Browse current movies", "Browse upcoming movies", ""};
		
		String choice = (String) JOptionPane.showInputDialog(
				null,
				"Select an Option: ",
				"Select an Option",
				JOptionPane.QUESTION_MESSAGE,
				null,
				menu,
				menu[3]);
		
		switch (choice) {
			case "Search movies" -> searchMovies();
			case "Browse current movies" -> browseCurrentMovies();
			case "Browse upcoming movies" -> browseUpcomingMovies();
		}		
	}
	
	private void searchMovies() {
		// TODO Auto-generated method stub
	}
	
	private void browseCurrentMovies() {
		// TODO Auto-generated method stub
	}
	
	private void browseUpcomingMovies() {
		// TODO Auto-generated method stub
	}

	private void loggedInAdmin() {
		System.out.println("successfully logged in as admin");
		
		String[] menu = {"Status Report", "Manage shows", ""};
		
		String choice = (String) JOptionPane.showInputDialog(
				null,
				"Select an Option: ",
				"Select an Option",
				JOptionPane.QUESTION_MESSAGE,
				null,
				menu,
				menu[2]);
	
		switch (choice) {
			case "Status Report" -> statusReport();
			case "Manage shows" -> manageShows();
		}
	}


	private void statusReport() {
		// TODO Auto-generated method stub
	}


	private void manageShows() {
		// TODO Auto-generated method stub
	}
	
}
