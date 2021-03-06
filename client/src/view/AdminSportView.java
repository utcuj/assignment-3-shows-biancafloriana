package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdminSportView implements IView{
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableShow;
    private DefaultTableModel modelShow;
    private JButton addButton;
    private JButton deleteButton;
    private JButton newRowButton;
    private JButton csvReport;
    private JButton pdfReport;
    private JScrollPane listShow;


    public AdminSportView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        newRowButton = new JButton("New Row");
       // csvReport = new JButton("Report csv");
        //pdfReport = new JButton("Report pdf");
        tableShow = new JTable();
        tableShow.setRowHeight(20);
        listShow = new JScrollPane(tableShow);
        listShow.setPreferredSize(new Dimension(750, 400));
        init();
    }

    private void init() {
        initTable();

        jpanel.add(listShow);
        jframe.setContentPane(jpanel);
        jpanel.add(addButton);
        jpanel.add(deleteButton);
        jpanel.add(newRowButton);
        //        jpanel.add(csvReport);
        //jpanel.add(pdfReport);
        jframe.setLocation(600, 200);
        jframe.setSize(800, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);

    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("id");
        cols.add("name");
        cols.add("description");
        cols.add("type");
        cols.add("team1");
        cols.add("team2");


        modelShow = new DefaultTableModel(null, cols) {
            public boolean isCellEditable(int row, int column) {
                return column != 0;
            }
        };
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

    public void addListenerAddB(ActionListener ButtonL) {
        addButton.addActionListener(ButtonL);

    }

    public void addListenerDeleteB(ActionListener ButtonL) {
        deleteButton.addActionListener(ButtonL);

    }



    public void addListenerNewRB(ActionListener ButtonL) {
        newRowButton.addActionListener(ButtonL);

    }

    public void printMessage(String s) {
        System.out.println(s);
    }

    public void updateRow(Vector medication) {
        int id = tableShow.getSelectedRow();
        modelShow.removeRow(id);
        modelShow.addRow(medication);
        modelShow.moveRow(tableShow.getRowCount() - 1, tableShow.getRowCount() - 1, id);
    }

    public void addShow(Vector medicationV) {
        modelShow.addRow(medicationV);
    }

    public void addNewRow() {
        modelShow.addRow(new Vector());
    }

    public void removeRow() {
        modelShow.removeRow(tableShow.getSelectedRow());
    }
}
