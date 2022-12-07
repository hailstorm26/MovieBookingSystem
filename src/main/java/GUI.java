import Movie.MovieHandler;
import User.UserHandler;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GUI {
	private static MovieHandler mh = MovieHandler.getInstance();
	JTextField username = new JTextField();
	JTextField password = new JTextField();
	
	JTextField name = new JTextField();
	JTextField emailAddr = new JTextField();
	JTextField phoneNumber = new JTextField();
	JTextField address = new JTextField();



	public void start() {
		System.out.println("starting GUI");
		if (MovieBookingSystem.getUser() == null ) {
            
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

		//create user account using UserHandler
		UserHandler.getInstance().create(nm, email, phone, addy, pw, false);
		
	}
	
	private void createAdmin() {
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

		//create admin account using UserHandler
		UserHandler.getInstance().create(nm, email, phone, addy, pw, true);
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
		JTextField searchBar = new JTextField();
		JButton searchButton = new JButton();


	}
	
	private void browseCurrentMovies() {

		ArrayList<String> titles = new ArrayList<>();
		for(int i = 0; i < mh.movies.size()/2; i++){
			titles.add(mh.movies.get(i).getTitle());
		}

		String[] titlesArr = new String[titles.size()];
		titlesArr = titles.toArray(titlesArr);


		JFrame frame = new JFrame("Current Movies");
		JButton backButton = new JButton("Back");
		JList movieList = new JList(titlesArr);
		JPanel p = new JPanel();
		p.add(backButton);
		p.add(movieList);
		frame.add(p);
		frameSettings(frame);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				loggedInUser();
			}
		});

		movieList.addListSelectionListener(new ListSelectionListener() {
				@Override
				public void valueChanged(ListSelectionEvent e) {
					int selected = movieList.getSelectedIndex();
					displayMovie("current", selected);
				}
			});

	}

	private void browseUpcomingMovies() {

		//TO DO: change this to fetch information from movie class

		ArrayList<String> titles = new ArrayList<>();
		for(int i = mh.movies.size()/2; i < mh.movies.size(); i++){
			titles.add(mh.movies.get(i).getTitle());
		}

		String[] titlesArr = new String[titles.size()];
		titlesArr = titles.toArray(titlesArr);

		JList movieList = new JList(titlesArr);
		JFrame frame = new JFrame("Upcoming Movies");
		JPanel p = new JPanel();
		JButton backButton = new JButton("Back");
		p.add(backButton);
		p.add(movieList);
		frame.add(p);
		frameSettings(frame);


		movieList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selected = movieList.getSelectedIndex();
				displayMovie("upcoming", selected);
			}
		});

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				loggedInUser();
			}
		});

	}

	private void displayMovie(String fromPage, int moviePick) {

		//TO DO: change this to fetch information from movie class

		String[] reviewsObject = {
				"review 1",
				"review 2",
				"review 3",
		};

		JFrame frame = new JFrame("Movie Details");

		ImageIcon i = new ImageIcon(mh.movies.get(moviePick).getImage());
		Image image = i.getImage();
		Image newimg = image.getScaledInstance(60, 70,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newimg);

		JLabel titleAndSynopsis = new JLabel(mh.movies.get(moviePick).getTitle() + mh.movies.get(moviePick).getDescription(), newIcon, SwingConstants.HORIZONTAL);
		JButton backButton = new JButton("Back");
		JLabel cast = new JLabel("cast...");
		JLabel runtime = new JLabel("runtime...");
		JButton bookButton = new JButton("Book Ticket");
		JLabel reviews = new JLabel("Reviews:");
		JButton reviewButton = new JButton("Write Review");
		JList reviewList = new JList(reviewsObject);

		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

		p.add(backButton);
		p.add(titleAndSynopsis);
		p.add(cast);
		p.add(runtime);
		p.add(bookButton);
		p.add(reviews);
		p.add(reviewList);
		p.add(reviewButton);

		frame.add(p);
		frameSettings(frame);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				if(fromPage.equals("current")) {
					browseCurrentMovies();
				}
				if(fromPage.equals("upcoming")) {
					browseUpcomingMovies();
				}
				if(fromPage.equals("search")) {
					searchMovies();
				}
			}
		});

		bookButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				bookTicket();
			}
		});

		reviewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				writeReview();
			}
		});
	}

	private void bookTicket() {
		//joptionpane for time, theater, payment method
		//after payment method selected, go to new screen for card info

	}

	private void writeReview(){
		JButton backButton = new JButton();

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

	private void frameSettings(JFrame f) {
		f.setSize(600, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.show();
	}

}
