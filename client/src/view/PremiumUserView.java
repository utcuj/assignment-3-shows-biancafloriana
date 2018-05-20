package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Vector;

public class PremiumUserView {

    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableShow;
    private DefaultTableModel modelShow;
    private JButton detailsButton, historyButton, recommend, interested;
    private JButton searchByNameB;
    private JScrollPane listShow, scrollPane1;
    private JTextField searchT, user;
    private JTextArea noti;
    private int rowNr = 0;

    public PremiumUserView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        detailsButton = new JButton("Details");
        searchByNameB = new JButton("Search by name");
        historyButton = new JButton("History");
        recommend = new JButton("Recommendation");
        interested = new JButton("Interested");
        tableShow = new JTable();
        listShow = new JScrollPane(tableShow);
        searchT = new JTextField(10);
        user = new JTextField(10);
        noti = new JTextArea(4, 30);
        scrollPane1 = new JScrollPane(noti);
        noti.setEditable(false);

        init();
    }

    private void init() {
        initTable();
        jpanel.add(listShow);
        jframe.setContentPane(jpanel);
        jpanel.add(detailsButton);
        jpanel.add(searchT);
        jpanel.add(searchByNameB);
        jpanel.add(historyButton);
        jpanel.add(interested);
        jpanel.add(user);
        jpanel.add(recommend);
        jpanel.add(noti);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("id");
        cols.add("name");
        cols.add("description");
        cols.add("type");

        modelShow = new DefaultTableModel(null, cols);
        tableShow.setModel(modelShow);
    }

    public Object[] getShow() {

        int id = tableShow.getSelectedRow();
        int colNumber = modelShow.getColumnCount();
        Object[] result = new Object[colNumber];

        for (int i = 0; i < colNumber; i++) {
            result[i] = tableShow.getModel().getValueAt(id, i);

        }

        return result;
    }

    public void addListenerDetails(ActionListener ButtonL) {
        detailsButton.addActionListener(ButtonL);

    }

    public void addListenerRecommend(ActionListener ButtonL) {
        recommend.addActionListener(ButtonL);

    }

    public void addListenerIntresed(ActionListener ButtonL) {
        interested.addActionListener(ButtonL);

    }

    public String getUser() {
        return user.getText();
    }

    public void addListenerHistory(ActionListener ButtonL) {
        historyButton.addActionListener(ButtonL);
    }

    public void addListenerSearch(ActionListener ButtonL) {
        searchByNameB.addActionListener(ButtonL);

    }

    public String getText() {
        return searchT.getText();
    }


    public void addShow(Vector Show) {
        modelShow.addRow(Show);
        rowNr++;
    }

    public void clear() {
        initTable();
    }

    public void addNotify(String text) {

        noti.append(text + "\n");
    }
}