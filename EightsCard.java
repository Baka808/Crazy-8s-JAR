public class EightsCard extends Card {
    public EightsCard(int rank, String suit) {
        super(rank, suit);
    }

    // check if two cards match per Crazy Eights rules
    public boolean match(EightsCard other) {
        return this.getRank() == 8 ||
               this.getRank() == other.getRank() ||
               this.getSuit().equals(other.getSuit());
    }

    // return points for the card
    public int scoreCard() {
        int rank = getRank();
        if (rank == 8) return 50;
        else if (rank >= 11) return 10; // J, Q, K
        else return rank; // number cards
    }
}