import java.util.ArrayList;

public class EightsHand extends ArrayList<EightsCard> {
    public int scoreHand() {
        int total = 0;
        for (EightsCard c : this) {
            total += c.scoreCard();
        }
        return total;
    }
}