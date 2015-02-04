package nl.lveekhout.matrix;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by eekhout.l on 16-1-15.
 * class StringMatrix
 */

public class StringMatrix {
    private List<OpleveringObjectType> stringMatrix = new ArrayList<OpleveringObjectType>();

    public boolean bestaat(String oplevering, String object, String type) {
        for (OpleveringObjectType opleveringObjectType : stringMatrix) {
            if (opleveringObjectType.oplevering.equalsIgnoreCase(oplevering) && opleveringObjectType.object.equalsIgnoreCase(object) && opleveringObjectType.type.equalsIgnoreCase(type)) {
                return true;
            }
        }

        return false;
    }

    public void voegToe(String oplevering, String object, String type, String value) {
        if (!bestaat(oplevering, object, type)) {
            stringMatrix.add(new OpleveringObjectType(oplevering, object, type));
        }
    }

    public StringMatrix match(StringMatrix other) {
        StringMatrix stringMatrix1 = new StringMatrix();
        for (OpleveringObjectType opleveringObjectType : stringMatrix) {
            if (other.bestaat(opleveringObjectType.oplevering, opleveringObjectType.object, opleveringObjectType.type)) {
                stringMatrix1.voegToe(opleveringObjectType.oplevering, opleveringObjectType.object, opleveringObjectType.type, "");
            }
        }
        return stringMatrix1;
    }

    public StringMatrix mismatch(StringMatrix other) {
        StringMatrix stringMatrix1 = new StringMatrix();
        for (OpleveringObjectType opleveringObjectType : stringMatrix) {
            if (!other.bestaat(opleveringObjectType.oplevering, opleveringObjectType.object, opleveringObjectType.type)) {
                stringMatrix1.voegToe(opleveringObjectType.oplevering, opleveringObjectType.object, opleveringObjectType.type, "");
            }
        }
        return stringMatrix1;
    }

    private class OpleveringObjectType {
        public String oplevering;
        public String object;
        public String type;

        OpleveringObjectType(String oplevering, String object, String type) {
            this.oplevering = oplevering;
            this.object = object;
            this.type = type;
        }
    }

    @Override
    public String toString() {
        String s = "";
        for (OpleveringObjectType opleveringObjectType : stringMatrix) {
//            s += String.format("%-30s %-30s %s\n", opleveringObjectType.oplevering, opleveringObjectType.object, opleveringObjectType.type);
            s += String.format("%s\t%s\t%s\n", opleveringObjectType.oplevering, opleveringObjectType.object, opleveringObjectType.type);
        }
        return s;
    }
}
