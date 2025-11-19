import java.util.*;

public class CrazyEightsTournament {
    public static void main(String[] args) {
        int smartWins = 0;
        int geniusWins = 0;

        int numSmart = 2;
        int numGenius = 2;

        Map<String,Integer> individualWins = new HashMap<>();

        for (int i = 0; i < 100; i++) {
            ArrayList<Player> players = new ArrayList<>();

            for (int s = 1; s <= numSmart; s++) {
                String name = "Smart" + s;
                SmartPlayer sp = new SmartPlayer(name);
                players.add(sp);
                individualWins.putIfAbsent(name, 0);
            }
            for (int g = 1; g <= numGenius; g++) {
                String name = "Genius" + g;
                GeniusPlayer gp = new GeniusPlayer(name);
                players.add(gp);
                individualWins.putIfAbsent(name, 0);
            }

            CrazyEightsGame game = new CrazyEightsGame(players);
            Player winner = game.playGame();

            individualWins.put(winner.name, individualWins.get(winner.name) + 1);
            if (winner instanceof SmartPlayer) smartWins++;
            else if (winner instanceof GeniusPlayer) geniusWins++;
        }

        System.out.println("\nAfter 100 games:");
        System.out.println("SmartPlayer wins: " + smartWins);
        System.out.println("GeniusPlayer wins: " + geniusWins);
        System.out.println("\nIndividual wins:");
        for (Map.Entry<String,Integer> entry : individualWins.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}