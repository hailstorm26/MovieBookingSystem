package Movie;

import User.UserHandler;

import java.util.*;

public class MovieHandler {
    // List of movies
    // Times and theaters are stored on object
    public ArrayList<Movie> movies = new ArrayList<Movie>();
    private static MovieHandler instance;

    public static MovieHandler getInstance() {
        if (instance == null) {
            Class<MovieHandler> var0 = MovieHandler.class;
            synchronized (var0) {
                if (instance == null) {
                    instance = new MovieHandler();
                }
            }
        }
        return instance;
    }

    public Movie search(String title) {
        return findIfPresent(title, movies);
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }

    public Movie createMovie(String title, String description, double price, HashMap<String, List<String>> showings) {
        return new Movie(title, description, price, 0, showings, null);
    }

    public void addShowing(String title, String theater, String time) {
        search(title).addShowing(theater, time);
    }

    public Set<String> getTheatersForMovie(String title) {
        return search(title).getShowings().keySet();
    }

    private Movie findIfPresent(String source, ArrayList<Movie> set)
    {
        if (set.contains(source)) {
            for (Movie obj : set) {
                if (obj.equals(source))
                    return obj;
            }
        }
        return null;
    }

    public void addReview(String movieTitle, double rating, String header, String review) {
        Review r = new Review(rating, header, UserHandler.getInstance().getUser().getName(), review);
        search(movieTitle).addReview(r);
    }

    public List<Review> getReviews(String title) {
        return search(title).getReviews();
    }
}
