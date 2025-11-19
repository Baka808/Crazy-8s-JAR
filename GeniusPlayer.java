public class GeniusPlayer extends Player {
    public GeniusPlayer(String name) { 
        super(name); 
    }

    @Override
    public EightsCard play(EightsCard topCard, Deck deck) {
        EightsCard best = null;
        for (EightsCard c : hand) {
            if (!canPlay(c, topCard)) continue;
            if (c.getRank() == 8) continue;
            if (best == null || c.getRank() < best.getRank()) {
                best = c;
            }
        }
        if (best != null) {
            hand.remove(best);
            return best;
        }
        for (EightsCard c : hand) {
            if (c.getRank() == 8) {
                hand.remove(c);
                return c;
            }
        }
        return super.play(topCard, deck);
    }
}