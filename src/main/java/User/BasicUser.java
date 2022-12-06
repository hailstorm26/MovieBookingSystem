package User;

import Ticket.Ticket;

public class BasicUser extends User {

    public BasicUser(String name, String email, String phoneNumber, String homeAddress, String password) {
    	super(name, email, phoneNumber, homeAddress, password);
    }

    public void addTicket(Ticket ticket) {
        super.getTickets().add(ticket);
    }
}
