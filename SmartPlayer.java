public class SmartPlayer extends Player {
    public SmartPlayer(String name) { 
        super(name); 
    }

    @Override
    public EightsCard play(EightsCard topCard, Deck deck) {
        EightsCard best = null;
        for (EightsCard c : hand) {
            if (!canPlay(c, topCard)) continue;
            if (c.getRank() == 8) {
                hand.remove(c);
                return c;
            }
            if (best == null || c.getRank() > best.getRank()) {
                best = c;
            }
        }
        if (best != null) {
            hand.remove(best);
            return best;
        }
        return super.play(topCard, deck);
    }
}