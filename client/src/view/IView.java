package view;

import java.awt.event.ActionListener;
import java.util.Vector;

public interface IView {
    Object[] getShow();

    void updateRow(Vector vector);



    void addListenerAddB(ActionListener addButtonL);

    void addNewRow();

    void printMessage(String s);

    void addListenerNewRB(ActionListener buttonL);

    void removeRow();

    void addListenerDeleteB(ActionListener buttonL);

    void addShow(Vector medV);
}
