/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package j2.s.p0202;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author nguoitamxa
 */
public class Controller {

    View view;

    public Controller() {
        view = new View();
        view.setVisible(true);
        view.getBtnConvert().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String box1 = (String) view.getCmb1().getSelectedItem();
                String box2 = (String) view.getCmb2().getSelectedItem();
                if (view.getTxt1().getText().isEmpty()) {
                    JOptionPane.showMessageDialog(view, "Not null value");
                } else if (view.getTxt1().getText().matches("[^1234567890]*$")) {
                    //[^123457890] - character differ number
                    //*$ - from beggin to end
                    JOptionPane.showMessageDialog(view, "Only number");
                    view.getTxt1().setText("");
                } else {
                    if (box1.equals("Meter") && box2.equals("Mile")) {
                        view.getTxt2().setText(Double.parseDouble(view.getTxt1().getText()) * 0.621368875 + "");
                    }
                    if (box1.equals("Mile") && box2.equals("Meter")) {
                        view.getTxt2().setText(Double.parseDouble(view.getTxt1().getText()) / 0.621368875 + "");
                    }
                    if (box1.equals("Meter") && box2.equals("Kilometer")) {
                        view.getTxt2().setText(Double.parseDouble(view.getTxt1().getText()) / 1000 + "");
                    }
                    if (box1.equals("Kilometer") && box2.equals("Meter")) {
                        view.getTxt2().setText(Double.parseDouble(view.getTxt1().getText()) * 1000 + "");
                    }
                    if (box1.equals("Mile") && box2.equals("Kilometer")) {
                        view.getTxt2().setText(Double.parseDouble(view.getTxt1().getText()) * 0.621368875 / 1000 + "");
                    }
                    if (box1.equals("Kilometer") && box2.equals("Mile")) {
                        view.getTxt2().setText(Double.parseDouble(view.getTxt1().getText()) / 0.621368875 * 1000 + "");
                    }
                    if (box1.equals(box2)) {
                        JOptionPane.showMessageDialog(view, "Must different");
                        view.getTxt1().setText("");
                    }
                }
            }
        });
    }

}
