package uebung1.businesslogic;

public class RomanNumberTransformer implements NumberTransformer{

    @Override
    public String transformNumber(int number) {
        //if (number <= 0) {
        //    return "";
        //}
        //imWertebereich für (<=3000 >=1)
        String NichtImBereich = imWertebereich(number);
        if(NichtImBereich !=null){
            return NichtImBereich;
        }

        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (number >= values[i]) {
                result.append(numerals[i]);
                number -= values[i];
            }
        }

        return result.toString();
    }

    @Override
    public String getTransformerType() {
        return "Transformer für römische Zahlen";
    }
}
