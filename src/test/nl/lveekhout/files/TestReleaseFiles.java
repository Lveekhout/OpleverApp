package nl.lveekhout.files;

import nl.lveekhout.files.ReleaseFiles;

import java.io.File;

/**
 * Created by leekhout on 18-1-2015.
 * class TestReleaseFiles
 */

public class TestReleaseFiles {
    public static void main(String[] args) {
        try {
            ReleaseFiles releaseFiles = new ReleaseFiles("c:\\Temp\\17_Opleveren\\PartyScene\\Sprint 21", new File("C:\\Users\\leekhout\\Google Drive\\Sub\\Dev\\ExcelApp"));
            System.out.println(releaseFiles);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
