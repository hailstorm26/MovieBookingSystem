import Movie.Movie;
import Movie.MovieHandler;
import Ticket.TicketHandler;
import User.UserHandler;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;


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

		String[] menu = {"Log out","My Tickets","Search movies", "Browse current movies", "Browse upcoming movies", ""};
		
		String choice = (String) JOptionPane.showInputDialog(
				null,
				"Select an Option: ",
				"Select an Option",
				JOptionPane.QUESTION_MESSAGE,
				null,
				menu,
				menu[5]);

		switch (choice) {
			case "Log out" -> logOut();
			//case "My Tickets" -> myTickets();
			case "Search movies" -> searchMovies();
			case "Browse current movies" -> browseCurrentMovies();
			case "Browse upcoming movies" -> browseUpcomingMovies();
		}
	}

	private void logOut() {
		System.out.println("successfully logged out as user");
		System.exit(0);
	}

	private void myTickets(String movieTitle, String movieTime, String movieTheater) {
		int ticketBarcode = (int)(Math.random() * 9999);
		if(ticketBarcode <= 100000) {
			ticketBarcode = ticketBarcode + 100000;
		}

		JFrame frame = new JFrame();

		JLabel header = new JLabel("My Ticket: ");
		JLabel title = new JLabel(movieTitle);
		JLabel time = new JLabel(movieTime);
		JLabel theater = new JLabel(movieTheater);
		JLabel barcode = new JLabel(String.valueOf(ticketBarcode));

		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));
		p.add(header);
		p.add(title);
		p.add(time);
		p.add(theater);
		p.add(barcode);

		frame.add(p);
		frameSettings(frame);

	}

	private void searchMovies() {
		JTextField searchBar = new JTextField();
		Object[] userInput =  {
				"Search: ", searchBar,
		};

		JOptionPane.showConfirmDialog(null, userInput, "Searching", JOptionPane.OK_CANCEL_OPTION);
		String search = searchBar.getText();
		searchForMovie(search);
	}
	private void searchForMovie(String searchEnter) {
		Movie result = mh.search(searchEnter);
		int index = mh.movies.indexOf(result);
		displayMovie("search",index);
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

		int count = mh.movies.size()/2;
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
				int selected = movieList.getSelectedIndex() + count;
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
		Image newimg = image.getScaledInstance(120, 150,  java.awt.Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newimg);

		JLabel titleAndPicture = new JLabel(mh.movies.get(moviePick).getTitle() , newIcon, SwingConstants.HORIZONTAL);
		JLabel synopsis = new JLabel("<html><p>"+mh.movies.get(moviePick).getDescription()+"</p></html>");
		JButton backButton = new JButton("Back");
		JLabel cast = new JLabel("Star cast: "+ mh.movies.get(moviePick).getCast());
		JLabel runtime = new JLabel("Runtime: "+ mh.movies.get(moviePick).getRuntime());
		JButton bookButton = new JButton("Book Ticket");
		JLabel reviews = new JLabel("Reviews:");
		JButton reviewButton = new JButton("Write Review");
		//JList reviewList = new JList(reviewsObject);

		JPanel p = new JPanel();

		p.setLayout(new BoxLayout(p, BoxLayout.PAGE_AXIS));

		p.add(backButton);
		p.add(titleAndPicture);
		p.add(synopsis);
		p.add(cast);
		p.add(runtime);
		p.add(bookButton);
		p.add(reviews);
		//p.add(reviewList);
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
				bookTicket(moviePick);
			}
		});

		reviewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				writeReview(moviePick);
			}
		});
	}

	private void bookTicket(int moviePick) {
		HashMap<String, List<String>> menu = mh.movies.get(moviePick).getShowings();

		ArrayList<String> theaterChoice = new ArrayList<String>();
		ArrayList<String> timeChoice = new ArrayList<String>();
		for(String key : menu.keySet()) {
			theaterChoice.add(key);
			for(String element: menu.get(key)) {
				timeChoice.add(element);
			}
		}

		//convert to arrays
		String[] theaterArr = new String[theaterChoice.size()];
		theaterArr = theaterChoice.toArray(theaterArr);
		String[] timeArr = new String[timeChoice.size()];
		timeArr = timeChoice.toArray(timeArr);

		//payment method arr
		String[] paymentArr = {"Credit", "Debit", "Paypal"};

		//seats arr
		String[] seatsArr = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

		//choices
		String choice = (String) JOptionPane.showInputDialog(
				null,
				"Choose theater: ",
				"Book Ticket",
				JOptionPane.QUESTION_MESSAGE,
				null,
				theaterArr,
				theaterArr[0]);

		String choice2 = (String) JOptionPane.showInputDialog(
				null,
				"Choose time: ",
				"Book Ticket",
				JOptionPane.QUESTION_MESSAGE,
				null,
				timeArr,
				timeArr[0]);

		String choice3 = (String) JOptionPane.showInputDialog(
				null,
				"Choose payment method: ",
				"Book Ticket",
				JOptionPane.QUESTION_MESSAGE,
				null,
				paymentArr,
				paymentArr[0]);

		String choice4 = (String) JOptionPane.showInputDialog(
				null,
				"Choose number of seats: ",
				"Book Ticket",
				JOptionPane.QUESTION_MESSAGE,
				null,
				seatsArr,
				seatsArr[0]);


		String title = mh.movies.get(moviePick).getTitle();
		String time = choice;
		String theater = choice2;
		int seats = Integer.parseInt(choice4);
		double price = mh.movies.get(moviePick).getPrice();
		buyTicket(title, time, theater, seats, price);
	}

	private void buyTicket(String title, String time, String theater, int seats, double price) {
		JTextField cardNum = new JTextField();
		JTextField name = new JTextField();
		JTextField cvvCode = new JTextField();
		JTextField expDate = new JTextField();
		JTextField billingAddress = new JTextField();


		Object[] userInput =  {
				"Card number: ", cardNum,
				"Name on card: ", name,
				"CVV: ", cvvCode,
				"Expiration date: ", expDate,
				"Billing address: ", billingAddress,
		};

		JOptionPane.showConfirmDialog(null, userInput, "Purchase Ticket", JOptionPane.OK_CANCEL_OPTION);
		String card = cardNum.getText();
		String nm = name.getText();
		String cvv = cvvCode.getText();
		String exp = expDate.getText();
		String addr = billingAddress.getText();

		//validate information
		TicketHandler.getInstance().purchaseTicket(title, time, theater, card, cvv, seats, price);
		System.out.println("successfully bought ticket:" + "\ntime: " + time + "\ntheater: " + theater + "\nseats: " + seats);

		//display ticket
		myTickets(title, time, theater);
	}

	private void writeReview(int movie) {
		JButton backButton = new JButton("Back");
		String[] reviewGrade = {"1", "2", "3","4","5"};

		String choice = (String) JOptionPane.showInputDialog(
				null,
				"Select an Option: ",
				"Select an Option",
				JOptionPane.QUESTION_MESSAGE,
				null,
				reviewGrade,
				reviewGrade[4]);
		String rating = choice;

		JTextField header = new JTextField();
		JTextField review = new JTextField();
		Object[] userInput =  {
				"Header: ", header,
				"Review: ", review,
		};

		JOptionPane.showConfirmDialog(null, userInput, "Write Review", JOptionPane.OK_CANCEL_OPTION);

		String title = mh.movies.get(movie).getTitle();
		String headerText = header.getText();
		String reviewText = review.getText();

		mh.addReview(title,Double.parseDouble(rating), headerText,reviewText);
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
		//list of movies and tickets sold
		ArrayList<String> titles = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < mh.movies.size(); i++){
			titles.add(mh.movies.get(i).getTitle() + "   - Tickets Sold: " + random.nextInt(1+10) + 1);
		}
		String[] titlesArr = new String[titles.size()];
		titlesArr = titles.toArray(titlesArr);

		JList movieList = new JList(titlesArr);
		JFrame frame = new JFrame("Admin: Status Report");
		JPanel p = new JPanel();
		JButton backButton = new JButton("Back");
		p.add(backButton);
		p.add(movieList);
		frame.add(p);
		frameSettings(frame);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				loggedInAdmin();
			}
		});
	}


	private void manageShows() {
		ArrayList<String> titles = new ArrayList<>();
		for(int i =0; i < mh.movies.size(); i++){
			titles.add(mh.movies.get(i).getTitle());
		}
		String[] titlesArr = new String[titles.size()];
		titlesArr = titles.toArray(titlesArr);

		JList movieList = new JList(titlesArr);
		JFrame frame = new JFrame("Admin: Manage Shows");
		JPanel p = new JPanel();
		JButton backButton = new JButton("Back");
		p.add(backButton);
		p.add(movieList);
		frame.add(p);
		frameSettings(frame);

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				loggedInAdmin();
			}
		});
	}

	private void frameSettings(JFrame f) {
		f.setSize(600, 500);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.show();
	}

}
