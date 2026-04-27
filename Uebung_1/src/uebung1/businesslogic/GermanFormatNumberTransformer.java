package uebung1.businesslogic;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class GermanFormatNumberTransformer implements NumberTransformer{

    @Override
    public String transformNumber(int number) {
        //imWertebereich für (<=3000 >=1)
        String NichtImBereich = imWertebereich(number);
        if(NichtImBereich !=null){
            return NichtImBereich;
        }

        DecimalFormat germanFormat = new DecimalFormat("#.###", DecimalFormatSymbols.getInstance(Locale.GERMANY));
        return germanFormat.format(number);
    }

    @Override
    public String getTransformerType() {
        return "Transformer für deutsche Zahlenformatierungen";
    }
}
