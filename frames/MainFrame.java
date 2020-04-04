package frames;

import javax.swing.*;

public class MainFrame extends JFrame {
    public static MainMenu menu;
    public static LoginPage loginPage;
    public static RegisterPage registerPage;
    public static TicketsPage ticketsPage;
    public static UserPage userPage;
    public static GenrePage genrePage;
    public static GoPage goPage;
    public static MoviePage moviePage;

    public MainFrame() {
        setTitle("MOVIE");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 700);
        setLayout(null);
        setLocationRelativeTo(null);



        ticketsPage = new TicketsPage(null);
        ticketsPage.setLocation(0, 0);
        ticketsPage.setVisible(false);

        goPage = new GoPage(null,null,null);
        goPage.setLocation(0, 0);
        goPage.setVisible(false);

        moviePage = new MoviePage(null,null);
        moviePage.setLocation(0, 0);
        moviePage.setVisible(false);

        genrePage = new GenrePage(null);
        genrePage.setLocation(0, 0);
        genrePage.setVisible(false);

        userPage = new UserPage(null);
        userPage.setLocation(0, 0);
        userPage.setVisible(false);

        loginPage = new LoginPage();
        loginPage.setLocation(0, 0);
        loginPage.setVisible(false);

        registerPage = new RegisterPage();
        registerPage.setLocation(0, 0);
        registerPage.setVisible(false);


        menu = new MainMenu();
        menu.setLocation(0, 0);
        menu.setVisible(true);
        add(menu);

    }

    public  void allAdd(){
        add(goPage);
        add(moviePage);
        add(genrePage);
        add(userPage);
        add(loginPage);
        add(ticketsPage);
        add(registerPage);

    }

}
