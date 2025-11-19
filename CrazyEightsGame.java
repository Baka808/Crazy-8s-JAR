import java.util.*;

public class CrazyEightsGame {
    private List<Player> players;
    private Deck deck;

    public CrazyEightsGame(List<Player> players) {
        this.players = players;
        this.deck = new Deck();
    }

    public Player playGame() {
        // deal 5 cards to each player
        for (int i = 0; i < 5; i++) {
            for (Player p : players) {
                EightsCard c = deck.draw();
                if (c != null) p.takeCard(c);
            }
        }

        EightsCard topCard = deck.draw();
        if (topCard == null) return players.get(0);

        int current = 0;
        while (true) {
            Player p = players.get(current);
            EightsCard played = p.play(topCard, deck);
            if (played != null) {
                topCard = played;
                if (p.hasWon()) return p;
            }
            current = (current + 1) % players.size();
            boolean anyCanPlay = false;
            for (Player pl : players) {
                for (EightsCard c : pl.hand) {
                    if (c.match(topCard)) { anyCanPlay = true; break; }
                }
                if (anyCanPlay) break;
            }
            if (!anyCanPlay && deck.isEmpty()) {
                Player best = players.get(0);
                int bestScore = best.hand.scoreHand();
                for (Player pl : players) {
                    int s = pl.hand.scoreHand();
                    if (s < bestScore) { best = pl; bestScore = s; }
                }
                return best;
            }
        }
    }
}
