package frames;

import models.Genre;
import servers.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class GenrePage extends Container {
    private JLabel label;
    private JComboBox genres;
    private JButton go;
    private JButton back;
    private Long userId;
    public Genre genre1;

    public GenrePage(Long userId){
        this.userId=userId;
        setSize(700,700);
        setLayout(null);

        JLabel background;
        ImageIcon img = new ImageIcon("/Users/nurlan/Desktop/projects/javaProjects/imovie/src/media/backgrounds/GenrePage.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(25,0,650,676);

        label=new JLabel("***Genres***");
        label.setBounds(300,150,150,100);
        label.setForeground(Color.GREEN);
        add(label);

        Genre [] genress=null;
        final ArrayList<Genre>[] genre = new ArrayList[]{Menu.getGenres()};
        genress = genre[0].toArray(new Genre[genre[0].size()]);

        genres=new JComboBox(genress);
        genres.setBounds(230,200,250,150);
        add(genres);

        go=new JButton("Go");
        go.setBounds(230,360,250,30);
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

               genre1 =(Genre)genres.getSelectedItem();
               servers.Menu.showMoviePage(getUserId(),genre1.getId());
            }

        });
        add(go);

        back=new JButton("Back");
        back.setBounds(310,610,130,40);
        back.setForeground(Color.red);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Menu.showUserPage(getUserId());
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

}
