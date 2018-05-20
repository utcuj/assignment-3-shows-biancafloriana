package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Vector;

public class HistoryView {
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableShow;
    private DefaultTableModel modelShow;
    private JScrollPane listShow;


    public HistoryView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        tableShow = new JTable();
        listShow = new JScrollPane(tableShow);
        init();
    }

    private void init() {
        initTable();
        jpanel.add(listShow);
        jframe.setContentPane(jpanel);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("Show");


        modelShow = new DefaultTableModel(null, cols);
        tableShow.setModel(modelShow);
    }


    public void addActivity(Vector Show) {
        modelShow.addRow(Show);

    }

}


