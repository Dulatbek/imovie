package frames;

import models.User;
import servers.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UserPage extends Container {
    private JButton genre;
    private JButton tickets;
    private Long userId;
    private JButton logout;


    public UserPage(Long userId){
        this.userId=userId;
        setSize(700, 700);
        setLayout(null);

        JLabel background;
        ImageIcon img = new ImageIcon("/Users/nurlan/Desktop/projects/javaProjects/imovie/src/media/backgrounds/UserPage.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);


        genre=new JButton("Genres");
        genre.setBounds(250,150,200,50);
        genre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                servers.Menu.showGenrePage(getUserId());
            }
        });
        add(genre);

        tickets=new JButton("My Tickets");
        tickets.setBounds(250,250,200,50);
        tickets.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                servers.Menu.showTicketsPage(getUserId());
            }
        });
        add(tickets);

        logout=new JButton("Logout");
        logout.setBounds(250,350,200,50);
        logout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Menu.showMenuPage();
            }
        });
        add(logout);
        add(background);
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


}