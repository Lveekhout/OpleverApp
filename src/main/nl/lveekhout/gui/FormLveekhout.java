package nl.lveekhout.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by leekhout on 18-1-2015.
 * class FormLveekhout
 */

public class FormLveekhout {
    private Window window;
    private Thread thread;
    private JTextArea textArea1;
    private JPanel panel1;
    private JPanel panel2;
    private JButton sluitenButton;
    private JScrollPane scrollPanel1;
    private JButton button1;
    private JButton startThreadButton;
    private JPanel threadPanel;
    private JButton stopThreadButton;
    private JTextField threadField;
    private JScrollPane excelScrollPane;
    private JTextArea textArea2;
    private JScrollPane filesScrollPane;
    private JTextArea textArea3;
    private JSplitPane splitPane;
    private JPanel matrixPanel;

    public FormLveekhout(final Window window) {
        this.window = window;
        textArea1.setText("Dit is een Lveekhout production: " + scrollPanel1.getMaximumSize().toString() + "\n\n");
        sluitenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (thread != null && thread.isAlive()) {
                    thread.interrupt();
                    try {
                        thread.join();
                    } catch (InterruptedException e1) {
                    }
                    startThreadButton.setEnabled(true);
                    stopThreadButton.setEnabled(false);
                }
                FormLveekhout.this.window.dispose();
            }
        });
        startThreadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                thread = new Thread(new MyLoop());
                thread.start();
                startThreadButton.setEnabled(false);
                stopThreadButton.setEnabled(true);
            }
        });
        stopThreadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (thread.isAlive()) {
                    thread.interrupt();
                    try {
                        thread.join();
                    } catch (InterruptedException e1) {}
                    startThreadButton.setEnabled(true);
                    stopThreadButton.setEnabled(false);
                }
            }
        });
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public JTextArea getTextArea1() { return textArea1; }
    public JTextArea getTextArea2() {
        return textArea2;
    }
    public JTextArea getTextArea3() {
        return textArea3;
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    private class MyLoop implements Runnable {
        @Override
        public void run() {
            Integer i;
            try {
                while (true) {
                    Thread.sleep(100);
                    i = Integer.parseInt(threadField.getText());
                    threadField.setText((++i).toString());
                    textArea2.append(String.format("[%-40s - %s]\n", "Laurens van Eekhout", Thread.currentThread().getName()));
                }
            } catch (NumberFormatException nfe) {
            } catch (InterruptedException ie) {}
        }
    }
}
