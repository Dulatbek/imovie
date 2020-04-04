package servers;

import frames.*;
import models.Genre;
import models.Movie;
import models.Ticket;
import models.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;


public class Menu {

    public static ObjectOutputStream outputStream;
    public static ObjectInputStream inputStream;
    public static Socket socket;
    public static MainFrame frame;

    public static void connectToServer() {
        try {
            socket = new Socket("localhost", 3999);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            inputStream = new ObjectInputStream((socket.getInputStream()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createUser(User user) {
        PackageData pd = new PackageData();
        pd.setOperationType("Create_User");
        pd.setUser(user);
        try {
            outputStream.writeObject(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void createTicket(Ticket ticket) {
        PackageData pd = new PackageData();
        pd.setOperationType("Create_Ticket");
        pd.setTicket(ticket);
        try {
            outputStream.writeObject(pd);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<User> getUsers() {

        ArrayList<User> users = new ArrayList<>();
        PackageData pd = new PackageData();
        pd.setOperationType("Get_Users");
        pd.setUsers(users);
        try {
            outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                users = pd.getUsers();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public static ArrayList<Ticket> getTickets() {

        ArrayList<Ticket> tickets = new ArrayList<>();
        PackageData pd = new PackageData();
        pd.setOperationType("Get_Tickets");
        pd.setTickets(tickets);
        try {
            outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                tickets = pd.getTickets();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public static ArrayList<Genre> getGenres() {
        ArrayList<Genre> genres = new ArrayList<>();
        PackageData pd = new PackageData();
        pd.setOperationType("Get_Genres");
        pd.setGenres(genres);
        try {
            outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                genres = pd.getGenres();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genres;
    }

    public static ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        PackageData pd = new PackageData();
        pd.setOperationType("Get_Movies");
        pd.setMovies(movies);
        try {
            outputStream.writeObject(pd);
            if ((pd = (PackageData) inputStream.readObject()) != null) {
                movies = pd.getMovies();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }

    public static void showLoginPage() {
        Menu.frame.menu.setVisible(false);
        Menu.frame.registerPage.setVisible(false);
        Menu.frame.ticketsPage.setVisible(false);
        Menu.frame.genrePage.setVisible(false);
        Menu.frame.moviePage.setVisible(false);
        Menu.frame.goPage.setVisible(false);
        Menu.frame.allAdd();
        Menu.frame.userPage.setVisible(false);
        Menu.frame.loginPage.setVisible(true);
        Menu.frame.repaint();
    }

    public static void showRegisterPage() {
        Menu.frame.menu.setVisible(false);
        Menu.frame.loginPage.setVisible(false);
        Menu.frame.userPage.setVisible(false);
        Menu.frame.genrePage.setVisible(false);
        Menu.frame.goPage.setVisible(false);
        Menu.frame.ticketsPage.setVisible(false);
        Menu.frame.moviePage.setVisible(false);
        Menu.frame.allAdd();
        Menu.frame.registerPage.setVisible(true);
        Menu.frame.repaint();
    }

    public static void showMenuPage() {
        Menu.frame.registerPage.setVisible(false);
        Menu.frame.loginPage.setVisible(false);
        Menu.frame.ticketsPage.setVisible(false);
        Menu.frame.userPage.setVisible(false);
        Menu.frame.goPage.setVisible(false);
        Menu.frame.moviePage.setVisible(false);
        Menu.frame.allAdd();
        Menu.frame.genrePage.setVisible(false);
        Menu.frame.menu.setVisible(true);
        Menu.frame.repaint();
    }

    public static void showUserPage(Long userId) {
        Menu.frame.registerPage.setVisible(false);
        Menu.frame.loginPage.setVisible(false);
        Menu.frame.ticketsPage.setVisible(false);
        Menu.frame.menu.setVisible(false);
        Menu.frame.genrePage.setVisible(false);
        Menu.frame.goPage.setVisible(false);
        Menu.frame.moviePage.setVisible(false);
        Menu.frame.allAdd();
        Menu.frame.userPage.setUserId(userId);
        Menu.frame.userPage.setVisible(true);
        Menu.frame.repaint();
    }

    public static void showTicketsPage(Long userId) {
        MainFrame.registerPage.setVisible(false);
        frame.loginPage.setVisible(false);
        Menu.frame.menu.setVisible(false);
        Menu.frame.userPage.setVisible(false);
        Menu.frame.moviePage.setVisible(false);
        Menu.frame.genrePage.setVisible(false);
        Menu.frame.ticketsPage.setUserId(userId);
        Menu.frame.ticketsPage = new TicketsPage(userId);
        Menu.frame.allAdd();
        Menu.frame.goPage.setVisible(false);
        Menu.frame.ticketsPage.setVisible(true);
        Menu.frame.repaint();
    }

    public static void showGenrePage(Long userId) {
        Menu.frame.registerPage.setVisible(false);
        Menu.frame.loginPage.setVisible(false);
        Menu.frame.menu.setVisible(false);
        Menu.frame.ticketsPage.setVisible(false);
        Menu.frame.userPage.setVisible(false);
        Menu.frame.goPage.setVisible(false);
        Menu.frame.genrePage.setUserId(userId);
        Menu.frame.allAdd();
        Menu.frame.moviePage.setVisible(false);
        Menu.frame.genrePage.setVisible(true);
        Menu.frame.repaint();
    }

    public static void showGoPage(Long userId,Long genreId,Long movieId) {
        Menu.frame.registerPage.setVisible(false);
        Menu.frame.loginPage.setVisible(false);
        Menu.frame.menu.setVisible(false);
        Menu.frame.ticketsPage.setVisible(false);
        Menu.frame.userPage.setVisible(false);
        Menu.frame.genrePage.setVisible(false);
        Menu.frame.moviePage.setVisible(false);
        Menu.frame.goPage.setUserId(userId);
        Menu.frame.goPage.setGenreId(genreId);
        Menu.frame.goPage.setMovieId(movieId);
        Menu.frame.goPage.setVisible(false);
        Menu.frame.goPage = new GoPage(userId,genreId,movieId);
        Menu.frame.allAdd();
        Menu.frame.goPage.setVisible(true);
        Menu.frame.goPage.repaint();
        Menu.frame.repaint();

    }

    public static void showMoviePage(Long userId,Long genreId) {
        Menu.frame.loginPage.setVisible(false);
        Menu.frame.registerPage.setVisible(false);
        Menu.frame.menu.setVisible(false);
        Menu.frame.ticketsPage.setVisible(false);
        Menu.frame.userPage.setVisible(false);
        Menu.frame.genrePage.setVisible(false);
        Menu.frame.goPage.setVisible(false);
        Menu.frame.moviePage.setUserId(userId);
        Menu.frame.moviePage.setGenreId(genreId);
        Menu.frame.moviePage.setVisible(false);
        Menu.frame.moviePage.renderGenre();
        Menu.frame.allAdd();
        Menu.frame.moviePage.setVisible(true);
        Menu.frame.moviePage.repaint();
        Menu.frame.repaint();
    }

    public static void main(String[] args) {

        connectToServer();
        frame = new MainFrame();
        frame.setVisible(true);
    }
}
