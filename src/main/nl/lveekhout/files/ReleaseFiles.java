package nl.lveekhout.files;

import nl.lveekhout.lists.GeneralList;
import nl.lveekhout.matrix.StringMatrix;

import javax.swing.*;
import java.io.File;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by eekhout.l on 15-1-15.
 * class ReleaseFiles
 */

public class ReleaseFiles {
    private GeneralList teamList;
    private GeneralList objectList;
    private GeneralList ignoreList;

    private JTextArea textArea;

    public String team;
    public String release;
    public StringMatrix stringMatrix = new StringMatrix();
    public Set<String> ongeldigeReleaseSet = new HashSet<>();
    public Set<String> ongeldigeDirectorySet = new HashSet<>();
    public Set<String> onbekendFileSet = new HashSet<>();

    private void appendTextArea(String s) {
        if (textArea!=null) {
            textArea.append(s);
        } else {
            System.out.println(s);
        }
    }

    public ReleaseFiles(String inputDir, File baseDir) throws Exception {
        this(inputDir, baseDir, null);
    }

    public ReleaseFiles(String inputDir, File baseDir, JTextArea textArea) throws Exception {
        File file = new File(inputDir);

        if (!file.exists()) {
            throw new Exception("File bestaat niet: [" + inputDir + "]");
        }

        this.textArea = textArea;

        teamList = new GeneralList(baseDir.getPath() + "\\TeamList.txt");
        objectList = new GeneralList(baseDir.getPath() + "\\ObjectList.txt");
        ignoreList = new GeneralList(baseDir.getPath() + "\\IgnoreList.txt");

        team = file.getParentFile().getName();
        release = file.getName();

        if (teamList.get(team)==null) {
            throw new Exception("Onbekend team: " + team);
        }

        appendTextArea("Naam: " + file.getName() + "\n");
        appendTextArea("Path: " + file.getPath() + "\n");
        appendTextArea("getParent : " + file.getParentFile().getName() + "\n");
        appendTextArea("File : " + (file.isFile() ? "Yes" : "No") + "\n");
        appendTextArea("Dir : " + (file.isDirectory() ? "Yes" : "No") + "\n");
        appendTextArea("canWrite : " + (file.canWrite() ? "Yes" : "No") + "\n");

        IterateRelease(file);
    }

    private void IterateRelease(File file) {
        appendTextArea(String.format("\nIterateRelease: [" + file.getName() + "]\n"));
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                if (file1.toString().lastIndexOf("_")<0) {
                    ongeldigeReleaseSet.add(file1.getPath());
                } else {
                    IterateOplevering(file1);
                }
            } else if (file1.isFile()) {
                int lastIndexOf = file1.getName().lastIndexOf(".");
                String extention = file1.getName().substring(lastIndexOf);
                if (!ignoreList.matches(file1.getName())) {
                    String type = objectList.get(extention);
                    if (type!=null) {
                        appendTextArea(String.format("\n\tOplevering: [" + file1.getName() + "]\n"));
                        appendTextArea(String.format("\t\t%-15s %-15s %-48s %-10s\n", team, release, file1.getName().split("-ear")[0], type)); //TODO: Harcodes -ear eruit halen
                        stringMatrix.voegToe(file1.getName(), file1.getName().substring(0, lastIndexOf), type, file1.getPath());
                    } else {
                        onbekendFileSet.add(file1.getPath());
                    }
                }
            } else {
                onbekendFileSet.add(file1.getPath());
            }
        }
    }

    private void IterateOplevering(File file) {
        appendTextArea(String.format("\n\tIterateOplevering: [" + file.getName() + "]\n"));
        for (File file1 : file.listFiles()) {
            if (file1.isDirectory()) {
                switch (file1.getName().toLowerCase()) {
                    case "ddl": IterateDdl(file1); break;
                    case "fmx": IterateFmx(file1); break;
                    default: //TODO: Opnemen in ongeldige lijst
                             break;
                }
            }
        }
    }

    private void IterateDdl(File file) {
        String oplevering = file.getParentFile().getName();
        appendTextArea(String.format("\n\t\tIterateDdl: [" + oplevering + "]\n"));
        for (File file1 : file.listFiles()) {
            if (file1.isFile()) {
                int lastIndexOf = file1.getName().lastIndexOf(".");
                String extention = file1.getName().substring(lastIndexOf);
//                if (ignoreList.get(extention)== null) {
                if (!ignoreList.matches(file1.getName())) {
                    if (file1.getName().toLowerCase().indexOf(oplevering.toLowerCase())==0) {
                        String type = objectList.get(extention);
                        if (type!=null) {
                            appendTextArea(String.format("\t\t\t%-15s %-15s %-48s %-10s\n", team, release, file1.getName().substring(oplevering.length()+1), type));
                            stringMatrix.voegToe(oplevering, file1.getName().substring(oplevering.length() + 1).substring(0, lastIndexOf - 1 - oplevering.length()), type, file1.getPath());
                        } else {
                            appendTextArea(String.format("\t\t\tOnbekend type: %-15s %-15s %-48s %-10s\n", team, release, file1.getName().substring(oplevering.length()+1), type));
                            onbekendFileSet.add(file1.getPath());
                        }
                    } else {
                        appendTextArea(String.format("\t\t\tBegint niet met release: %-15s %-15s %-48s\n", team, release, file1.getName()));
                        onbekendFileSet.add(file1.getPath());
                    }
                } else {
                    appendTextArea(String.format("\t\t\tIgnore: %-15s %-15s %-48s\n", team, release, file1.getName()));
                    onbekendFileSet.add(file1.getPath());
                }
            } else {
                appendTextArea(String.format("\t\t\tGeen file: %-15s %-15s %-48s\n", team, release, file1.getName()));
                onbekendFileSet.add(file1.getPath());
            }
        }
    }

    private void IterateFmx(File file) {
        String oplevering = file.getParentFile().getName();
        appendTextArea(String.format("\n\t\tIterateFmx: [" + oplevering + "]\n"));
        for (File file1 : file.listFiles()) {
            if (file1.isFile()) {
                int lastIndexOf = file1.getName().lastIndexOf(".");
                String extention = file1.getName().substring(lastIndexOf);
//                if (ignoreList.get(extention)== null) {
                if (!ignoreList.matches(file1.getName())) {
                    String type = objectList.get(extention);
                    if (type!=null) {
                        appendTextArea(String.format("\t\t\t%-15s %-15s %-48s %-10s\n", team, release, file1.getName(), type));
                        stringMatrix.voegToe(oplevering, file1.getName().substring(0, lastIndexOf), type, file1.getPath());
                    } else {
                        onbekendFileSet.add(file1.getPath());
                    }
                }
            } else {
                onbekendFileSet.add(file1.getPath());
            }
        }
    }

    @Override
    public String toString() {
        String s = "\nReleaseFiles{}\n";
        s += stringMatrix;
        return s;
    }
}