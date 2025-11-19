public class Player {
    protected EightsHand hand = new EightsHand();
    protected String name;

    public Player(String name) { 
        this.name = name; 
    }

    public void takeCard(EightsCard c) { 
        hand.add(c); 
    }

    public boolean hasWon() { 
        return hand.isEmpty(); 
    }

    public boolean canPlay(EightsCard c, EightsCard topCard) {
        return c.match(topCard);
    }

    public EightsCard play(EightsCard topCard, Deck deck) {
        for (EightsCard c : hand) {
            if (canPlay(c, topCard)) {
                hand.remove(c);
                return c;
            }
        }
        if (!deck.isEmpty()) {
            EightsCard newCard = deck.draw();
            hand.add(newCard);
            if (canPlay(newCard, topCard)) {
                hand.remove(newCard);
                return newCard;
            }
        }
        return null;
    }

    @Override
    public String toString() { 
        return name; 
    }
}