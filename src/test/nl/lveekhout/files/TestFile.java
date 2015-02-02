package nl.lveekhout.files;

import java.io.File;
import java.io.IOException;

/**
 * Created by leekhout on 21-1-2015.
 * class TestFile
 */

public class TestFile {
    public static void main(String[] args) {
        File file = new File("c:\\abc\\..\\def\\");
        System.out.println(file.getPath());
    }
}
