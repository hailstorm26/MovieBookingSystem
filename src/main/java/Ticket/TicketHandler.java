package Ticket;

import Movie.Movie;
import Movie.MovieHandler;
import User.User;
import User.BasicUser;
import User.UserHandler;

import java.util.HashMap;
import java.util.Map;

public class TicketHandler {
    public Map<User, Ticket> storage = new HashMap<>();

    private static TicketHandler instance;

    public static TicketHandler getInstance() {
        if (instance == null) {
            Class<TicketHandler> var0 = TicketHandler.class;
            synchronized (var0) {
                if (instance == null) {
                    instance = new TicketHandler();
                }
            }
        }
        return instance;
    }

    public boolean removeTicket(User AUser, Ticket ticket) {
        try {
            AUser.getTickets().remove(ticket);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Map<User, Ticket> getTickets() {
        return storage;
    }

    public Ticket purchaseTicket(String title, String time, String theater, String cardNumber, String CVV, int seat, double price) {
        Movie m = MovieHandler.getInstance().search(title);
        if (!Payment.validateCard(cardNumber) || !Payment.validateCVV(CVV) || m == null ||
                !m.getShowings().keySet().contains(theater) || !m.getShowings().get(title).contains(time)) {
            return null;
        }
        Ticket ticket = new Ticket(time, theater, seat, price);

        UserHandler uh = UserHandler.getInstance();
        storage.put(uh.getUser(), ticket);
        if (uh.getUser() instanceof BasicUser) {
            ((BasicUser) uh.getUser()).addTicket(ticket);
        }
        Movie movie = MovieHandler.getInstance().search(title);
        movie.setTicketsSold(movie.getTicketsSold() + 1);
        return ticket;
    }
}
