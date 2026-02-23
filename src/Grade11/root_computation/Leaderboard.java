package Grade11.root_computation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Player {
    String name;
    int score;

    Player(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class Leaderboard {
    private final List<Player> players = new ArrayList<>();

    public void addPlayer(String name, int score) {
        players.add(new Player(name, score));
        Collections.sort(players, Comparator.comparingInt(player -> -player.score));
        if (players.size() > 10) {
            players.remove(players.size() - 1);
        }
    }

    public void printTopPlayers() {
        System.out.println("Top 10 Players:");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).name + ": " + players.get(i).score);
        }
    }

    static void main(String[] args) {
        Leaderboard leaderboard = new Leaderboard();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Enter player name: ");
            String name = scanner.nextLine();
            System.out.println("Enter player score: ");
            int score = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            leaderboard.addPlayer(name, score);
            leaderboard.printTopPlayers();
        }
    }
}
