package frames;

import models.Movie;
import models.Ticket;
import servers.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GoPage  extends Container {
    private JLabel label;
    private JLabel price;
    private JLabel time;
    private JLabel countLabel;
    private JTextField count;
    private JButton buy;
    private JButton back;

    private Long userId;
    private Long genreId;
    private Long movieId;

    public GoPage(Long userId, Long genreId, Long movieId) {

        this.userId=userId;
        this.genreId=genreId;
        this.movieId=movieId;

        setLayout(null);
        setSize(700, 700);

        JLabel background;
        ImageIcon img = new ImageIcon("/Users/nurlan/Desktop/projects/javaProjects/imovie/src/media/backgrounds/GoPage.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(50, 40, 600, 600);
        label = new JLabel("***Movie***");
        label.setBounds(320, 100, 150, 40);
        add(label);

        countLabel = new JLabel("Counts of tickets:");
        countLabel.setBounds(230, 200, 148, 50);
        add(countLabel);
        count = new JTextField();
        count.setBounds(380, 200, 100, 50);
        add(count);

        price = new JLabel();
        price.setBounds(230, 150, 250, 40);

        time = new JLabel();
        time.setBounds(500, 150, 150, 40);
        int id;

        ArrayList<Movie> movies = Menu.getMovies();
        if (Objects.nonNull(this.genreId) && Objects.nonNull(this.userId) && Objects.nonNull(this.movieId)) {

            List<Movie> filteredMovies = movies
                    .stream()
                    .filter(e -> e.getId().equals(this.movieId))
                    .collect(Collectors.toList());

            for (int i = 0; i < filteredMovies.size(); i++) {
                Movie movie = filteredMovies.get(i);
                price.setText("Price is " + String.valueOf(movie.getPrice()) + "KZT");
                time.setText("Time: " + movie.getTime());
            }
        }
        add(price);
        add(time);

        buy = new JButton("Buy");
        buy.setBounds(230, 260, 250, 40);
        buy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String count1 = count.getText();
                Ticket ticket = new Ticket(null,getUserId(),getGenreId(),getMovieId(),movies.get(getMovieId().intValue()-1).getName(),movies.get(getMovieId().intValue()-1).getTime(),count1);
                Menu.createTicket(ticket);
                count.setText("");
                Menu.showMoviePage(getUserId(), getGenreId());
            }
        });
        add(buy);
        back = new JButton("Back");
        back.setBounds(310, 570, 130, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Menu.showMoviePage(getUserId(), getGenreId());
            }
        });
        add(back);
        add(background);


    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getGenreId() {
        return genreId;
    }

    public void setGenreId(Long genreId) {
        this.genreId = genreId;
    }

    public Long getMovieId() {
        return movieId;
    }

    public void setMovieId(Long movieId) {
        this.movieId = movieId;
    }


}
