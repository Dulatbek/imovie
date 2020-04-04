package frames;

import models.User;
import servers.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;



public class RegisterPage extends Container {
    private JLabel registrationLabel;
    private JLabel usernameLabel;
    private JTextField username;
    private JLabel nameLabel;
    private JTextField name;
    private JLabel surnameLabel;
    private JTextField surname;
    private JLabel passwordLabel;
    private JPasswordField password;
    private JLabel rePasswordLabel;
    private JPasswordField rePassword;
    private JButton register;
    private JLabel labelUsernameExit;
    private JLabel labelIfPasswordsNoneEqual;
    private JButton back;

    public RegisterPage(){
        setSize(700, 700);
        setLayout(null);
        JLabel background;
        ImageIcon img = new ImageIcon("/Users/nurlan/Desktop/projects/javaProjects/imovie/src/media/backgrounds/RegistrationPage.jpg");
        background = new JLabel("",img,JLabel.CENTER);
        background.setBounds(0,0,700,700);

        registrationLabel=new JLabel("***Registration***");
        registrationLabel.setBounds(290,70,150,70);
        add(registrationLabel);
        usernameLabel=new JLabel("Username");
        usernameLabel.setBounds(180,150,70,40);
        add(usernameLabel);
        username=new JTextField();
        username.setBounds(280,150,250,30);
        add(username);

        nameLabel=new JLabel("Name");
        nameLabel.setBounds(180,190,70,40);
        add(nameLabel);
        name=new JTextField();
        name.setBounds(280,190,250,30);
        add(name);

        surnameLabel=new JLabel("Surname");
        surnameLabel.setBounds(180,240,70,40);
        add(surnameLabel);
        surname=new JTextField();
        surname.setBounds(280,240,250,30);
        add(surname);

        passwordLabel=new JLabel("Password");
        passwordLabel.setBounds(180,280,70,30);
        add(passwordLabel);
        password=new JPasswordField();
        password.setBounds(280,280,250,30);
        add(password);


        rePasswordLabel=new JLabel("Re Password");
        rePasswordLabel.setBounds(180,320,99,30);
        add(rePasswordLabel);
        rePassword=new JPasswordField();
        rePassword.setBounds(280,320,250,30);
        add(rePassword);

        labelUsernameExit=new JLabel("");
        labelUsernameExit.setBounds(180,450,350,30);
        labelIfPasswordsNoneEqual=new JLabel("");
        labelIfPasswordsNoneEqual.setBounds(180,490,350,30);
        register=new JButton("Register");
        register.setBounds(180,360,350,30);
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ArrayList<User>users=Menu.getUsers();
                if(password.getText().equals(rePassword.getText())){
                    try{
                        for(User u:users){
                            if(!username.getText().equals("")&&!password.getText().equals("")&&!surname.getText().equals("")&&!name.getText().equals("")) {
                                System.out.println(u.getUsername());
                                if (!u.getUsername().equals(username.getText())) {
                                    User user = new User(null, name.getText(), surname.getText(), username.getText(), password.getText());
                                    Menu.createUser(user);
                                    Menu.showMenuPage();
                                    username.setText("");
                                    password.setText("");
                                    name.setText("");
                                    surname.setText("");
                                }
                            }
                        }
                    }catch (Exception e){e.printStackTrace();}
                }
                else{
                    password.setText("");
                    rePassword.setText("");
                    labelIfPasswordsNoneEqual.setText("Пароли не совподают!!!");
                }
            }
        });
        add(register);
        add(labelIfPasswordsNoneEqual);
        add(labelUsernameExit);

        back=new JButton("Back");
        back.setBounds(540,620,110,30);
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Menu.showMenuPage();
            }
        });
        add(back);
        add(background);
    }

}














