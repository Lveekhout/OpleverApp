package nl.lveekhout.matrix;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by leekhout on 15-1-2015.
 * class List3d
 */

public class List3d {
    Map<String,Map<String,Map<String,String>>> hashMap = new HashMap<String, Map<String, Map<String, String>>>();

    public boolean Bestaat(String s1, String s2, String s3) {
//        for (String s : stringList) {
//            if (s.equalsIgnoreCase(s1)) {
//                for
//            }
//        }
        return false;
    }
    public void VoegToe(String s1, String s2, String s3, String value){
        Iterator iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            if (entry.getKey().toString().equalsIgnoreCase(s1)){
                Iterator iterator2 = ((Map)entry.getValue()).entrySet().iterator();
                while (iterator2.hasNext()) {
                    Map.Entry entry2 = (Map.Entry)iterator2.next();
                    if (entry2.getKey().toString().equalsIgnoreCase(s2)){
                        Iterator iterator3 = ((Map)entry2.getValue()).entrySet().iterator();
                        while (iterator3.hasNext()) {
                            Map.Entry entry3 = (Map.Entry)iterator3.next();
                            if (entry3.getKey().toString().equalsIgnoreCase(s3)) {
                                return;
                            }
                        }
                        ((Map<String,String>)entry2.getValue()).put(s3, value);
                        return;
                    }
                }
                ((Map<String,Map<String,String>>)entry.getValue()).put(s2, new HashMap<String, String>());
                ((Map<String,Map<String,String>>)entry.getValue()).get(s2).put(s3, value);
                return;
            }
        }
        hashMap.put(s1, new HashMap<String, Map<String, String>>());
        hashMap.get(s1).put(s2, new HashMap<String, String>());
        hashMap.get(s1).get(s2).put(s3, value);
    }
}
