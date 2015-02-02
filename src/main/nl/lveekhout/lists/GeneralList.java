package nl.lveekhout.lists;

import java.io.*;
import java.util.HashMap;

/**
 * Created by eekhout.l on 16-1-15.
 * class GeneralList
 */

public class GeneralList extends HashMap<String, String> {
    public GeneralList(String listFilename) {
        File file = new File(listFilename);

        try {
            FileInputStream fileInputStream = new FileInputStream(file.getAbsoluteFile());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
            try {
                String s;
                while ((s=bufferedReader.readLine())!=null) {
                    String[] keyVal = s.split("\t");
                    put(keyVal[0], keyVal[1]);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return;
        }
    }

    public boolean matches(String s) {
        for (String s1 : this.keySet())
            if (s.matches(s1))
                return true;
        return false;
    }
}
