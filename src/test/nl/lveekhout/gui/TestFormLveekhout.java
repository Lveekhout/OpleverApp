package nl.lveekhout.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by eekhout.l on 20-1-15.
 * class TestFormLveekhout
 */

public class TestFormLveekhout {
    public static void main(String[] args) {
        JFrame frame = new JFrame("PPS Kern Oplevertool");
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setContentPane(new FormLveekhout(frame).getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
