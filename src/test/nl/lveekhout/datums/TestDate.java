package nl.lveekhout.datums;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by eekhout.l on 05-02-2015.
 * class TestDate
 */

public class TestDate {
    public static void main(String args[]) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss / dd-MM-yyyy");
        Date date = new Date();
        System.out.println(dateFormat.format(date));
    }
}
