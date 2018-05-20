package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.util.Vector;

public class AdminEmployeeView {

    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableUser;
    private DefaultTableModel modelUser;
    private JButton addButton;
    private JButton deleteButton;
    private JButton newRowButton;
    private JScrollPane listUser;
    private int rowNr = 0;

    public AdminEmployeeView() {
        jframe = new JFrame();
        jpanel = new JPanel();
        addButton = new JButton("Add");
        deleteButton = new JButton("Delete");
        newRowButton = new JButton("New Row");
        tableUser = new JTable();
        listUser = new JScrollPane(tableUser);

        init();
    }

    private void init() {
        initTable();
        jpanel.add(listUser);
        jframe.setContentPane(jpanel);
        jpanel.add(addButton);
        jpanel.add(deleteButton);
        jpanel.add(newRowButton);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    private void initTable() {
        Vector<String> cols = new Vector();
        cols.add("id");
        cols.add("Username");
        cols.add("Password");
        cols.add("Type");

        modelUser = new DefaultTableModel(null, cols);
        tableUser.setModel(modelUser);
    }

    public Object[] getUser() {

        int id = tableUser.getSelectedRow();
        Object[] result = new Object[6];

        result[0] = tableUser.getModel().getValueAt(id, 0);
        result[1] = tableUser.getModel().getValueAt(id, 1);
        result[2] = tableUser.getModel().getValueAt(id, 2);
        result[3] = tableUser.getModel().getValueAt(id, 3);
        result[4] = rowNr;
        result[5] = id;

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

    public void addUser(Vector user) {
        modelUser.addRow(user);
        rowNr++;
    }

    public void addNewRow() {
        modelUser.addRow(new Object[]{});
    }

    public void removeRow() {
        modelUser.removeRow(tableUser.getSelectedRow()); rowNr--;
    }

}
