package exercises.Uebung_3;

import java.util.List;

public class PersonCardView {
    public void showContent(List<PersonCard> cards) {
            for (PersonCard card : cards) {
                System.out.println(card.getDisplayInfo());
            }
        System.out.println("Aktueller Inhalt der CardBox:");

        for (PersonCard card : cards) {
            System.out.println(card);
        }
    }
}
