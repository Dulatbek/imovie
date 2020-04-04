package frames;

import servers.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends Container {
    private JButton register;
    private JButton login;
    private JButton exit;

    public MainMenu(){


        setSize(700, 700);
        setLayout(null);
        JLabel background;
        ImageIcon img = new ImageIcon("/Users/nurlan/Desktop/projects/javaProjects/imovie/src/media/backgrounds/MainMenu.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);



        login=new JButton("Login");
        login.setLocation(40,80);
        login.setSize(150,50);
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                Menu.showLoginPage();
            }
        });
        add(login);

        register= new JButton("Register");
        register.setLocation(515, 80);
        register.setSize(150, 50);
        register.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                servers.Menu.showRegisterPage();
            }
        });
        add(register);

        exit=new JButton("Exit" );
        exit.setBounds(515,570,150,50);
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                System.exit(0);
            }
        });
        add(exit);
        add(background);

    }

}
