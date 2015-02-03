package nl.lveekhout.lists;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eekhout.l on 03-02-2015.
 * class TestListAdd
 */

public class TestListAdd {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();
        List<String> stringList2 = new ArrayList<>();

        stringList2.add("A");
        stringList2.add("B");
        stringList2.add("C");

        stringList.addAll(stringList2);
        stringList.addAll(stringList2);
    }
}
