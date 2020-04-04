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

public class TicketsPage extends Container {
    private JLabel label;
    private JTextArea tickets;
    private JButton back;

    private Long userId;

    public TicketsPage(Long userId){
        this.userId=userId;

        setSize(700,700);
        setLayout(null);

        JLabel background;
        ImageIcon img = new ImageIcon("/Users/nurlan/Desktop/projects/javaProjects/imovie/src/media/backgrounds/TicketsPage.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(25,0,650,676);
        label=new JLabel("***Tickets***");
        label.setBounds(450,50,150,50);
        add(label);

        tickets = new JTextArea();
        tickets.setBounds(350,100,300,400);

        ArrayList<Ticket>tickets1 = Menu.getTickets();
        if (Objects.nonNull(this.userId)) {
            List<Ticket> filteredTickets = tickets1
                    .stream()
                    .filter(e -> e.getUser_id().equals(this.userId))
                    .collect(Collectors.toList());

            for (int i = 0; i < filteredTickets.size(); i++) {

                Ticket ticket = filteredTickets.get(i);

                tickets.setText(tickets.getText()+ticket.toString()+"\n");
            }
        }
        add(tickets);
        back=new JButton("Back");
        back.setBounds(450,550,150,40);
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
