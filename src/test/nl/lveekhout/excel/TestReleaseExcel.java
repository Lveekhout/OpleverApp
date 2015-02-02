package nl.lveekhout.excel;

import java.io.IOException;

/**
 * Created by eekhout.l on 26-1-15.
 * class TestReleaseExcel
 */

public class TestReleaseExcel {
    public static void main(String[] args) throws Exception {
        try {
            System.out.println("CurrentDir: " + System.getProperty("user.dir"));
            System.out.println("Argumenten: " + args.length);

            for (String s : args) {
                System.out.println("\t- " + s);
            }

//            if (args.length!=2) {
//                throw new Exception("Twee argumenten nodig");
//            }

            ReleaseExcel releaseExcel = new ReleaseExcel("PartyScene", "Sprint 28", "G:\\Temp\\17_Opleveren\\TEST.xls");
            System.out.println(releaseExcel.stringMatrix.toString());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
