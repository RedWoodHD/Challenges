import java.util.Scanner;
import java.util.Random;

public class MenschAergereDichNicht {

    public static void main(String[] args) {
        Game game = new Game();
        game.start();
    }
}

class Player {
    String name;
    String color;
    int[] positions = new int[4];  // Positionen der 4 Spielfiguren
    boolean[] inHome = new boolean[4]; // True bedeutet Figur ist im Haus (Startbereich)

    public Player(String name, String color) {
        this.name = name;
        this.color = color;
        for (int i = 0; i < 4; i++) {
            positions[i] = -1; // Alle Figuren beginnen im Startbereich
            inHome[i] = true;  // Alle Figuren starten im Haus
        }
    }

    public void moveFigure(int figureIndex, int steps) {
        if (inHome[figureIndex]) {
            // Figur wird aus dem Haus auf das erste Spielfeld bewegt
            positions[figureIndex] = 0;
            inHome[figureIndex] = false;
        } else {
            positions[figureIndex] += steps;
        }
    }
}

class Game {
    private static final int TOTAL_FIELDS = 40;
    private Player[] players;
    private int currentPlayerIndex;
    private Scanner scanner;
    private Random rand;

    public Game() {
        players = new Player[4];
        scanner = new Scanner(System.in);
        rand = new Random();
    }

    public void start() {
        System.out.println("Willkommen bei 'Mensch ärgere dich nicht'!\n");

        // Spieler erstellen
        for (int i = 0; i < 4; i++) {
            System.out.print("Spieler " + (i + 1) + ", gib deinen Namen ein: ");
            String name = scanner.nextLine();
            System.out.print("Spieler " + (i + 1) + ", wähle eine Farbe: ");
            String color = scanner.nextLine();
            players[i] = new Player(name, color);
        }

        // Spiel beginnt
        currentPlayerIndex = 0;
        boolean gameRunning = true;

        while (gameRunning) {
            Player currentPlayer = players[currentPlayerIndex];
            System.out.println("\n" + currentPlayer.name + " ist am Zug (Farbe: " + currentPlayer.color + ")");
            rollAndMove(currentPlayer);

            // Überprüfen, ob das Spiel zu Ende ist
            if (checkVictory(currentPlayer)) {
                System.out.println(currentPlayer.name + " hat das Spiel gewonnen!");
                gameRunning = false;
            }

            // Nächster Spieler
            currentPlayerIndex = (currentPlayerIndex + 1) % 4;
        }
    }

    private void rollAndMove(Player currentPlayer) {
        System.out.println("Drücke Enter, um zu würfeln...");
        scanner.nextLine();

        int diceRoll = rand.nextInt(6) + 1; // Würfeln zwischen 1 und 6
        System.out.println("Du hast eine " + diceRoll + " geworfen!");

        // Spieler muss eine Figur auswählen
        boolean validMove = false;
        while (!validMove) {
            System.out.print("Wähle eine Figur (1-4), um zu bewegen: ");
            int figure = scanner.nextInt();
            scanner.nextLine();

            if (figure < 1 || figure > 4) {
                System.out.println("Ungültige Eingabe, wähle eine Zahl zwischen 1 und 4.");
                continue;
            }

            figure--;  // Indizes starten bei 0
            if (currentPlayer.positions[figure] == -1) {
                System.out.println("Diese Figur ist noch im Haus. Du musst sie zuerst herausbewegen.");
            } else if (currentPlayer.positions[figure] + diceRoll > TOTAL_FIELDS) {
                System.out.println("Diese Bewegung führt über das Ziel hinaus. Wähle eine andere Figur.");
            } else {
                currentPlayer.moveFigure(figure, diceRoll);
                validMove = true;
                System.out.println("Figur " + (figure + 1) + " bewegt sich auf Feld " + currentPlayer.positions[figure]);
                checkForHit(currentPlayer, figure);
            }
        }
    }

    private void checkForHit(Player currentPlayer, int figureIndex) {
        int position = currentPlayer.positions[figureIndex];

        // Prüfen, ob die Figur auf einem Feld eines Gegners landet
        for (Player player : players) {
            if (player != currentPlayer) {
                for (int i = 0; i < 4; i++) {
                    if (player.positions[i] == position) {
                        // Gegnerfigur schlagen
                        player.positions[i] = -1; // Die Figur wird zurück ins Haus gesetzt
                        player.inHome[i] = true;
                        System.out.println("Du hast die Figur von " + player.name + " auf Feld " + position + " geschlagen und zurück ins Haus geschickt!");
                        return;
                    }
                }
            }
        }
    }

    private boolean checkVictory(Player currentPlayer) {
        // Wenn alle vier Figuren eines Spielers das Ziel erreicht haben
        for (int pos : currentPlayer.positions) {
            if (pos < TOTAL_FIELDS) {
                return false;
            }
        }
        return true;
    }
}
