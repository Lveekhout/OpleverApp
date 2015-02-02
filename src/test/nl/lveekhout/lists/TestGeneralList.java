package nl.lveekhout.lists;

import nl.lveekhout.lists.GeneralList;

/**
 * Created by eekhout.l on 16-1-15.
 * class TestGeneralList
 */

public class TestGeneralList {
    public static void main(String[] args) {
        GeneralList ignoreList = new GeneralList("IgnoreList.txt");
        GeneralList teamList = new GeneralList("TeamList.txt");
        System.out.println(ignoreList.toString());
        System.out.println(teamList.toString());

        System.out.println(ignoreList.matches("ipde-ibr-rgr-ear.1.23.580.sql"));
    }
}
