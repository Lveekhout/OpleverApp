package nl.lveekhout.matrix;

import nl.lveekhout.matrix.List3d;

/**
 * Created by leekhout on 16-1-2015.
 * class TestList3d
 */

public class TestList3d {
    public static void main(String[] args) {
        List3d list3d = new List3d();
        list3d.VoegToe("a", "a", "a", "waarde a.a.a");
        list3d.VoegToe("A", "A", "b", "waarde A.A.A");
    }
}
