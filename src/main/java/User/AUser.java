package User;

import Ticket.Ticket;
import lombok.Data;

import java.util.ArrayList;

@Data
public abstract class AUser {
	
    private String name;
    private String email;
    private String phoneNumber;
    private String homeAddress;
    private String password;
    private ArrayList<Ticket> tickets;
        
	protected AUser(String name, String email, String phoneNumber, String homeAddress, String password) {
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
		System.out.println("getting password");
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