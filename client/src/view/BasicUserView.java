package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Vector;

public class BasicUserView {

    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableShow;
    private DefaultTableModel modelShow;
    private JButton detailsButton,historyButton;
    private JButton searchByNameB;
    private JScrollPane listShow;
    private JTextField searchT;
    private int rowNr = 0;

    public BasicUserView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        detailsButton = new JButton("Details");
        searchByNameB = new JButton("Search by name");
        historyButton = new JButton("History");
        tableShow = new JTable();
        listShow = new JScrollPane(tableShow);
        searchT = new JTextField(10);

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

    public void addListenerHistory(ActionListener ButtonL) {
        historyButton.addActionListener(ButtonL);
    }

    public void addListenerSearch(ActionListener ButtonL) {
        searchByNameB.addActionListener(ButtonL);

    }

    public String getText(){
        return searchT.getText();
    }


    public void addShow(Vector Show) {
        modelShow.addRow(Show);
        rowNr++;
    }

    public void clear() {
        initTable();
    }
}
