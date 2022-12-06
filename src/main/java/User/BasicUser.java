package User;

import Ticket.Ticket;

public class BasicUser extends AUser {
	

    public BasicUser(String name, String email, String phoneNumber, String homeAddress, String password) {
    	super(name, email, phoneNumber, homeAddress, password);
    }

    public void addTicket(Ticket ticket) {
        super.getTickets().add(ticket);
    }
    
   
	
//	  public BasicUser(String name, String email, String phoneNumber, String homeAddress, String password) {
//	        super.setName(name);
//	        super.setEmail(email);
//	        super.setPhoneNumber(phoneNumber);
//	        super.setHomeAddress(homeAddress);
//	        super.setPassword(password);
//	    }
//
//	    public void addTicket(Ticket ticket) {
//	        super.getTickets().add(ticket);
//	    }
}
