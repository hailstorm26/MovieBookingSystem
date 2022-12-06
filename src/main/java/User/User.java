package User;

import Ticket.Ticket;
import lombok.Data;

import java.util.ArrayList;

@Data
public abstract class User {
	
    private String name;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String password;
    private ArrayList<Ticket> tickets;
    
	protected User(String name, String email, String phoneNumber, String homeAddress, String password) {
		name = this.name;
		email = this.email;
		phoneNumber = this.phoneNumber;
		homeAddress = this.homeAddress;
		password = this.password;
	}
	
	public String getName() {
		return name;
	}
	
	protected String getPassword() {
		return password;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}
	

}