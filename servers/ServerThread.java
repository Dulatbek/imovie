package servers;

import models.Genre;
import models.Movie;
import models.Ticket;
import models.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Connection connection;
    private Socket socket;
    ObjectInputStream inputStream;
    ObjectOutputStream outputStream;

    public ServerThread(Socket socket, Connection connection) {
        this.socket = socket;
        this.connection = connection;
        try {
            inputStream = new ObjectInputStream(this.socket.getInputStream());
            outputStream = new ObjectOutputStream(this.socket.getOutputStream());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        try {
            PackageData pd = null;
            while ((pd = (PackageData) inputStream.readObject()) != null) {

                if (pd.getOperationType().equals("Create_User")) {
                    try {
                        User user = pd.getUser();
                        addUserToDb(user);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (pd.getOperationType().equals("Get_Users")) {
                    try {
                        ArrayList<User> users = getUsersInDb();
                        PackageData packageData = new PackageData();
                        packageData.setUsers(users);
                        outputStream.writeObject(packageData);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (pd.getOperationType().equals("Get_Tickets")) {
                    try {
                        ArrayList<Ticket> tickets = getTicketsInDb();
                        PackageData packageData = new PackageData();
                        packageData.setTickets(tickets);
                        outputStream.writeObject(packageData);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (pd.getOperationType().equals("Get_Genres")) {
                    try {
                        ArrayList<Genre> genres = getGenresInDb();
                        PackageData packageData = new PackageData();
                        packageData.setGenres(genres);
                        outputStream.writeObject(packageData);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (pd.getOperationType().equals("Get_Movies")) {
                    try {
                        ArrayList<Movie> movies = getMoviesInDb();
                        PackageData packageData = new PackageData();
                        packageData.setMovies(movies);
                        outputStream.writeObject(packageData);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (pd.getOperationType().equals("Create_Ticket")) {
                    try {
                        Ticket ticket = pd.getTicket();
                        addTicketToDb(ticket);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addUserToDb(User user) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO users(id,name,surname,username,password) VALUES (null,?,?,?,?)");

            ps.setString(1, user.getName());
            ps.setString(2, user.getSurname());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addTicketToDb(Ticket ticket) {
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO tickets(id,user_id,genre_id,movie_id,movie_name,time,count) VALUES (null,?,?,?,?,?,?)");

            ps.setLong(1, ticket.getUser_id());
            ps.setLong(2, ticket.getGenre_id());
            ps.setLong(3, ticket.getMovie_id());
            ps.setString(4, ticket.getMovie_name());
            ps.setString(5, ticket.getTime());
            ps.setString(6, ticket.getCount());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<User> getUsersInDb() {
        ArrayList<User> users = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM users";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                users.add(new User(res.getLong("id"), res.getString("name"), res.getString("surname"), res.getString("username"), res.getString("password")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    public ArrayList<Ticket> getTicketsInDb() {
        ArrayList<Ticket> tickets = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM tickets";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                tickets.add(new Ticket(res.getLong("id"), res.getLong("user_id"), res.getLong("genre_id"), res.getLong("movie_id"), res.getString("movie_name"), res.getString("time"), res.getString("count")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tickets;
    }

    public ArrayList<Genre> getGenresInDb() {
        ArrayList<Genre> genres = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM genres";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                genres.add(new Genre(res.getLong("id"), res.getString("name")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return genres;
    }

    public ArrayList<Movie> getMoviesInDb() {
        ArrayList<Movie> movies = new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String sql = "SELECT * FROM movies";
            ResultSet res = st.executeQuery(sql);
            while (res.next()) {
                movies.add(new Movie(res.getLong("id"), res.getLong("genre_id"), res.getString("gif_way"), res.getString("name"), res.getInt("price"), res.getString("time")));
            }
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return movies;
    }
}