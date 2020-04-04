package servers;

import models.Genre;
import models.Movie;
import models.Ticket;
import models.User;

import java.io.Serializable;
import java.util.ArrayList;

public class PackageData implements Serializable {
    Genre genre;
    ArrayList<Genre> genres;
    Ticket ticket;
    ArrayList<Ticket>tickets;
    User user;
    ArrayList<User>users;
    Movie movie;
    ArrayList<Movie>movies;
    int user_id;
    int genre_id;
    int movie_id;
    String operationType;

    public PackageData()  {
    }

    public PackageData(Genre genre, ArrayList<Genre> genres, Ticket ticket, ArrayList<Ticket> tickets, User user, ArrayList<User> users, Movie movie, ArrayList<Movie> movies, int user_id, int genre_id, int movie_id, String operationType) {
        this.genre = genre;
        this.genres = genres;
        this.ticket = ticket;
        this.tickets = tickets;
        this.user = user;
        this.users = users;
        this.movie = movie;
        this.movies = movies;
        this.user_id = user_id;
        this.genre_id = genre_id;
        this.movie_id = movie_id;
        this.operationType = operationType;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ArrayList<Genre> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<Genre> genres) {
        this.genres = genres;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }
}
