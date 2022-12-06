package User;

import Ticket.Ticket;
//import lombok.Data;

import java.util.ArrayList;

//@Data
public abstract class AUser {
	
	protected String name;
	protected String email;
	protected String phoneNumber;
	protected String homeAddress;
	protected String password;
	protected ArrayList<Ticket> tickets;
        
	protected AUser(String name, String email, String phoneNumber, String homeAddress, String password) {
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.homeAddress = homeAddress;
		this.password = password;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

}