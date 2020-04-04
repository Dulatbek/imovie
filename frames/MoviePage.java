package frames;

import models.Movie;
import servers.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class MoviePage extends Container {
    private JLabel label;
    private List<JLabel> gifs = new ArrayList<>();
    private List<JButton> gifNames = new ArrayList<>();
    private Long userId;
    private Long genreId;
    private JLabel background;
    private JButton back;
    private ImageIcon img = new ImageIcon("/Users/nurlan/Desktop/projects/javaProjects/imovie/src/media/backgrounds/MoviePage.jpg");

    public MoviePage(Long userId,Long genreId) {
        this.userId=userId;
        this.genreId = genreId;

        setLayout(null);
        setSize(700, 700);


        label = new JLabel("***Movies***");
        label.setBounds(310, 50, 150, 50);
        label.setForeground(Color.GREEN);
        add(label);

        back = new JButton("Back");
        back.setBounds(110, 570, 490, 40);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Menu.showGenrePage(getUserId());
            }
        });
        add(back);

    }

    private void renderBackground() {
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(25, 0, 650, 676);
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



    public void renderGenre() {

        if (Objects.nonNull(this.genreId)) {
            ArrayList<Movie> movies = Menu.getMovies();
            List<Movie> filteredMovies = movies
                    .stream()
                    .filter(e -> e.getGenre_id().equals(this.genreId))
                    .collect(Collectors.toList());

            for (int i = 0; i < filteredMovies.size(); i++) {
                Movie movie = filteredMovies.get(i);
                JLabel gif1 = new JLabel();
                gif1.setBounds(110, 110 * (i + 1), 190, 100);
                gif1.setIcon(new ImageIcon(String.valueOf(movie.getGif_way())));
                add(gif1);
                gifs.add(gif1);
                validate();

                JButton gif1Name = new JButton(String.valueOf(movie.getName()));
                gif1Name.setBounds(310, 110 * (i + 1), 190, 20);
                gif1Name.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent actionEvent) {

                        servers.Menu.showGoPage(getUserId(),getGenreId(),movie.getId());

                    }
                });
                gifNames.add(gif1Name);
                add(gif1Name);
            }

            if (background != null) {
                remove(background);
            }
            renderBackground();
        }
    }



    @Override
    public void setVisible(boolean b) {
        super.setVisible(b);
        if (!b) {
            for (JLabel gif : gifs) {
                this.remove(gif);
            }

            for (JButton gif : gifNames) {
                this.remove(gif);
            }
        }
    }
}
