package nl.lveekhout.gui;

import javax.swing.*;
import java.awt.*;

/**
 * Created by leekhout on 24-1-2015.
 * class TestScrollable
 */

public class TestScrollable {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TestScrollable");
        frame.setPreferredSize(new Dimension(640, 480));
        frame.setContentPane(new Scrollable().getMainpanel());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
