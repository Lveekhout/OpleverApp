package nl.lveekhout.strings;

/**
 * Created by eekhout.l on 20-1-15.
 * class TestRegularExpression
 */

public class TestRegularExpression {
    public static void main(String[] args) {
        System.out.println("abc.Ear".matches(".*\\.(?i)ear(?-i)"));
        System.out.println("Dumpfile versie 3.00".matches("(Dumpfile )sjaakversie.*"));
    }
}
