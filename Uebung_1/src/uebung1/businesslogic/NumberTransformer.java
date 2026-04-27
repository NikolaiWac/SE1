package uebung1.businesslogic;
public interface NumberTransformer {

    default  String imWertebereich(int number) {
        if (number > 3000 || number < 1) {
            return "Zahl darf nicht kleiner als 1 und größer als 3.000 sein.";
        }
        return null;
    }
    String transformNumber ( int number);

    String getTransformerType();
}
