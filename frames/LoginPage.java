package frames;

import models.User;
import servers.Menu;
import servers.ServerThread;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class LoginPage extends Container {
    private JLabel LoginPage;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JLabel labelIfUserNameIsEqualNoneAndPasswordEqualNone;
    private JButton back;

    public LoginPage() {

        setSize(1200, 676);
        setLayout(null);

        JLabel background;
        ImageIcon img = new ImageIcon("/Users/nurlan/Desktop/projects/javaProjects/imovie/src/media/backgrounds/LoginPage.jpg");
        background = new JLabel("", img, JLabel.CENTER);
        background.setBounds(25, 0, 650, 676);

        LoginPage = new JLabel("***LOGIN***");
        LoginPage.setBounds(290, 90, 100, 40);
        LoginPage.setForeground(Color.blue);
        add(LoginPage);
        usernameLabel = new JLabel("Username");
        usernameLabel.setBounds(220, 150, 70, 40);
        add(usernameLabel);
        username = new JTextField();
        username.setBounds(300, 150, 150, 30);
        username.setBackground(Color.red);
        add(username);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(220, 200, 70, 30);
        add(passwordLabel);
        password = new JPasswordField();
        password.setBounds(300, 200, 150, 30);
        password.setBackground(Color.red);
        add(password);

        labelIfUserNameIsEqualNoneAndPasswordEqualNone = new JLabel("");
        labelIfUserNameIsEqualNoneAndPasswordEqualNone.setBounds(220, 300, 450, 30);

        if (username.getText().equals("") && password.getText().equals("")) {
            labelIfUserNameIsEqualNoneAndPasswordEqualNone.setText("");
        }
        login = new JButton("Login");
        login.setBounds(220, 240, 110, 30);
        login.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                labelIfUserNameIsEqualNoneAndPasswordEqualNone.setText("");
                ArrayList<User> users = Menu.getUsers();
                if (!username.getText().equals("") && !password.getText().equals("")) {
                    try {
                        boolean found = false;
                        for (User u : users) {

                            if (u.getUsername().equals(username.getText()) && u.getPassword().equals(password.getText())) {
                                servers.Menu.showUserPage(u.getId());
                                username.setText("");
                                password.setText("");
                                labelIfUserNameIsEqualNoneAndPasswordEqualNone.setText("");
                                found = true;
                            }
                        }

                        if (found) {
                            username.setText("");
                            password.setText("");
                            labelIfUserNameIsEqualNoneAndPasswordEqualNone.setText("Вы ввели неверные данные");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        login.setForeground(Color.blue);
        add(login);
        add(labelIfUserNameIsEqualNoneAndPasswordEqualNone);

        back = new JButton("Back");
        back.setBounds(335, 240, 110, 30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                username.setText("");
                password.setText("");
                labelIfUserNameIsEqualNoneAndPasswordEqualNone.setText("");
                Menu.showMenuPage();
            }
        });
        add(back);
        add(background);
    }
}