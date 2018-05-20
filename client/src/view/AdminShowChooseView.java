package view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class AdminShowChooseView {

    private JButton movie;
    private JButton theatre,sport;
    private JFrame jframe;
    private JPanel jpanel;

    public AdminShowChooseView() {

        jframe = new JFrame();
        jpanel = new JPanel();
        movie = new JButton("Movie");
        theatre = new JButton("Theatre");
        sport = new JButton("Sport Event");

        init();
    }

    private void init() {

        jframe.setContentPane(jpanel);
        jpanel.add(theatre);
        jpanel.add(movie);
        jpanel.add(sport);
        jframe.setLocation(600, 200);
        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    public void addListenerMovieB(ActionListener ButtonL) {
        movie.addActionListener(ButtonL);

    }

    public void addListenerTheatreB(ActionListener ButtonL) {
        theatre.addActionListener(ButtonL);

    }
    public void addListenerSportB(ActionListener ButtonL) {
        sport.addActionListener(ButtonL);

    }

    public void dispose() {
        jframe.dispose();
    }
}
