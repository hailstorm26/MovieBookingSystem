package User;

import Ticket.Ticket;
import lombok.Data;

import java.util.ArrayList;

@Data
public abstract class User{
    private String name;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String password;
    private ArrayList<Ticket> tickets;
    
	protected User(String name, String email, String phoneNumber, String homeAddress, String password) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.homeAddress = homeAddress;
		this.password = password;
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	

}