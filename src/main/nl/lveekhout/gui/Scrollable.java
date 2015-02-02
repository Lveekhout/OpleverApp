package nl.lveekhout.gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import java.awt.*;

/**
 * Created by leekhout on 24-1-2015.
 * class Scrollable
 */

public class Scrollable {
    private JPanel mainpanel;
    private JScrollPane scrollPane;
    private JTextArea getTextAreaTextArea;
    private JScrollPane scrollPane2;
    private JButton startButton;
    private JSplitPane splitPane;
    private JPanel panel1;
    private JRadioButton radioButton1;

    public Scrollable() {
        if (splitPane==null) System.out.println("splitPane==null");
        else {
            System.out.println(splitPane.toString());
            System.out.println(splitPane.getLayout().toString());
//            splitPane.setLayout(new MyLayout());
        }
    }

    public JPanel getMainpanel() {
        return mainpanel;
    }
}

class MyLayout extends FlowLayout implements LayoutManager {
    @Override
    public void layoutContainer(Container target) {
        System.out.println(target.toString());
        super.layoutContainer(target);
    }
}