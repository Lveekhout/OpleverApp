package nl.lveekhout.maps;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by eekhout.l on 21-01-2015.
 * class TestTreeMap
 */

public class TestTreeMap {
    public static void main(String[] args) {
        Map<String, String> map = new TreeMap<>();
        map.put("a", "a");
        map.put("a", "b");
    }
}
