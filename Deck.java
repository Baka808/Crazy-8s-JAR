import java.util.*;

public class Deck {
    private List<EightsCard> cards = new ArrayList<>();
    private Random rand = new Random();

    public Deck() {
        String[] suits = {"Hearts","Diamonds","Clubs","Spades"};
        for (String suit : suits) {
            for (int rank = 1; rank <= 13; rank++) {
                cards.add(new EightsCard(rank, suit));
            }
        }
        Collections.shuffle(cards);
    }

    public EightsCard draw() {
        if (!cards.isEmpty()) return cards.remove(0);
        return null;
    }

    public boolean isEmpty() { 
        return cards.isEmpty(); 
    }
}