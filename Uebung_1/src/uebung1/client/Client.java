package uebung1.client;

import uebung1.businesslogic.NumberTransformer;

public class Client {
    private final NumberTransformer transformer;

    public Client(NumberTransformer transformer) {
        this.transformer = transformer;
    }

    public void printTransformation(int number) {
        String result = transformer.transformNumber(number);
        System.out.println("Die römische Schreibweise der Zahl " +
                number + " ist: " + result);
    }
}