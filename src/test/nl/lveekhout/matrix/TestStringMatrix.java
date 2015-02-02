package nl.lveekhout.matrix;

/**
 * Created by eekhout.l on 16-1-15.
 * class TestStringMatrix
 */

public class TestStringMatrix {
    public static void main(String[] args) {
        StringMatrix stringMatrix = new StringMatrix();
        stringMatrix.voegToe("ars_1.23.456", "pasf0725", "Form", "");
        stringMatrix.voegToe("ARS_1.23.456", "PASF0725", "Form", "");
        stringMatrix.voegToe("ARS_1.23.456", "PASF0725_PCK", "Package", "");

        StringMatrix stringMatrix1 = new StringMatrix();
        stringMatrix1.voegToe("ARS_1.23.456", "PASF0725", "Form", "");
        stringMatrix1.voegToe("ARS_1.23.456", "PASF0725_PCK", "Packages", "");

        System.out.println("Left:");
        System.out.println(stringMatrix.mismatch(stringMatrix1).toString());
        System.out.println("Middle:");
        System.out.println(stringMatrix.match(stringMatrix1).toString());
        System.out.println("Right:");
        System.out.println(stringMatrix1.mismatch(stringMatrix).toString());
    }
}
