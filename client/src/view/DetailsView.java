package view;

import model.Show;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Vector;

public class DetailsView {

    private final JTextArea textArea,textArea1;
    private JFrame jframe;
    private JPanel jpanel;
    private JTable tableShow;
    private DefaultTableModel modelShow;
    private JButton commentButton;
    private JButton ratingButton;
    private JButton newRowButton;
    private JScrollPane listShow;
    private JScrollPane scrollPane,scrollPane1;
    private JTextArea t1;
    private JRadioButton b1,b2,b3,b4,b5;
    private int rowNr = 0;
    private  final ButtonGroup group = new ButtonGroup();

    public DetailsView(String type) {
        jframe = new JFrame();
        jpanel = new JPanel();
        commentButton = new JButton("Add Comment");
        ratingButton = new JButton("Add Rating");
       // newRowButton = new JButton("New Row");
        tableShow = new JTable();
        tableShow.setSize(400,50);
        listShow = new JScrollPane(tableShow);
        listShow.setPreferredSize(new Dimension(480, 50));
        textArea = new JTextArea(8, 40);
        scrollPane = new JScrollPane(textArea);
        textArea.setEditable(false);
        textArea1 = new JTextArea(8, 40);
        scrollPane1 = new JScrollPane(textArea1);
        textArea1.setEditable(false);
        t1 = new JTextArea(2,40);
        //t2 = new JTextArea(2,40);
        b1  = new JRadioButton("1");
        b2  = new JRadioButton("2");
        b3  = new JRadioButton("3");
        b4  = new JRadioButton("4");
        b5  = new JRadioButton("5");
        group.add(b1);
        group.add(b2);
        group.add(b3);
        group.add(b4);
        group.add(b5);


        init(type);
    }

    private void init(String type) {
        initTable(type);
       // listShow.setSize(400,50);
        jpanel.add(listShow);
        jframe.setContentPane(jpanel);
//        jpanel.add(newRowButton);
        jpanel.add(new JLabel("Comments:"));
        jpanel.add(scrollPane);
        jpanel.add(new JLabel("Ratings"));
        jpanel.add(scrollPane1);
        jpanel.add(t1);
        jpanel.add(commentButton);
        //jpanel.add(t2);
        jpanel.add(b1);
        jpanel.add(b2);
        jpanel.add(b3);
        jpanel.add(b4);
        jpanel.add(b5);

        jpanel.add(ratingButton);
        jframe.setLocation(600, 200);
        jframe.setSize(500, 600);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
        jframe.setVisible(true);
    }

    private void initTable(String type) {
        Vector<String> cols = new Vector();
        cols.add("id");
        cols.add("name");
        cols.add("description");
        cols.add("type");
        
        switch (type){
            
            case "movie":
                cols.add("actors");
                cols.add("rating");
                break;
            case "theatre":
                cols.add("actors");
                break;
            case "sport":
                cols.add("team1");
                cols.add("team2");
                break;


        }

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

        public void addListenerComment (ActionListener ButtonL){
            commentButton.addActionListener(ButtonL);

        }


        public void addListenerRating (ActionListener ButtonL){
            ratingButton.addActionListener(ButtonL);

        }


        public void addShow (Vector show){
            modelShow.addRow(show);
            rowNr++;
        }

        public void addComment(String text){

        textArea.append(text + "\n");
        }

    public void addRating(String text){

        textArea1.append(text + "\n");
    }


    public String getComment(){
        return t1.getText();
        }

     public int getRating(){

        if(b1.isSelected()){

            return Integer.parseInt(b1.getText());
        }
         if(b2.isSelected()){

             return Integer.parseInt(b2.getText());
         }
         if(b3.isSelected()){

             return Integer.parseInt(b3.getText());
         }
         if(b4.isSelected()){

             return Integer.parseInt(b4.getText());
         }
         if(b5.isSelected()){
             return Integer.parseInt(b5.getText());
         }
        return -1;
     }

    public void clear(String type) {
        textArea1.setText("");
        textArea.setText("");
        init(type);
    }
}
