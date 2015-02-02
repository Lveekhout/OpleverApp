package nl.lveekhout.app;

import nl.lveekhout.excel.ReleaseExcel;
import nl.lveekhout.files.ReleaseFiles;
import nl.lveekhout.gui.FormLveekhout;
import nl.lveekhout.gui.MyJFrame;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Created by leekhout on 18-1-2015.
 * class OracleSourceTool
 */

public class OracleSourceTool {
    public static void main(String[] args) throws Exception {
        MyJFrame frame = new MyJFrame("PPS Kern Oplevertool");
        frame.setPreferredSize(new Dimension(1280, 480));
        FormLveekhout formLveekhout = new FormLveekhout(frame);

        try {
            formLveekhout.getTextArea1().append("CurrentDir: " + System.getProperty("user.dir"));
            formLveekhout.getTextArea1().append("\n\nArgumenten: " + args.length + "\n");

            for (String s : args) {
                formLveekhout.getTextArea1().append("\t- " + s + "\n");
            }

            if (args.length!=2) {
                throw new Exception("Twee argumenten nodig");
            }

            ReleaseFiles releaseFiles = new ReleaseFiles(args[0], new File(args[1]), formLveekhout.getTextArea2());
            formLveekhout.getTextArea1().append("\nTeam: " + releaseFiles.team + "\n");
            formLveekhout.getTextArea1().append("Release: " + releaseFiles.release + "\n");
            formLveekhout.getTextArea1().append(releaseFiles.toString());

            ReleaseExcel releaseExcel = new ReleaseExcel("PartyScene", "Sprint 28", "G:\\Temp\\17_Opleveren\\TEST.xls", formLveekhout.getTextArea3());
            formLveekhout.getTextArea1().append(releaseExcel.toString());
        } catch (Exception e) {
            formLveekhout.getTextArea1().append("\n" + e.getMessage());
        }

        frame.setContentPane(formLveekhout.getPanel1());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
