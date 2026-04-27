package uebung1.businesslogic;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GermanFormatNumberTransformer implements NumberTransformer{

    @Override
    public String transformNumber(int number) {
        if (number > 3000){
            return "Zahl darf nicht größer als 3.000 sein.";
        }
        DecimalFormat germanFormat = new DecimalFormat("#.###", DecimalFormatSymbols.getInstance(Locale.GERMANY));
        return germanFormat.format(number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlenformatierungen";
    }
}
