package nl.lveekhout.strings;

import java.io.File;
import java.io.IOException;

/**
 * Created by eekhout.l on 20-1-15.
 * class TestRegularExpression
 */

public class TestRegularExpression {
    public static void main(String[] args) {
        File file = new File(".");
        System.out.println("X:\\ICT\\03 ICT Ontwikkeling\\02 ICT Bouw\\85 Teams\\PartyScene\\Sprint2015-03\\RGR_3.02.026\\Fmb\\pasf0850.fmb".matches(".*\\\\(?i)fmb(?-i)\\\\.*\\.(?i)fmb(?-i)"));
        System.out.println("Dumpfile versie 3.00".matches("(Dumpfile )sjaakversie.*"));
    }
}
