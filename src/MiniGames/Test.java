package MiniGames;

import java.util.Scanner;

public class Test
{
    public static void main(String[] args)
    {
        // Liste von möglichen Wörtern für das Spiel
        String[] words = {"hangman", "java"};//, "programming", "computer", "language
        // Zufälliges Wort aus der Liste auswählen
        String word = words[(int) (Math.random() * words.length)];

        // Erstellen eines Arrays, um die aktuell erratenen Buchstaben zu verfolgen
        char[] guessedWord = new char[word.length()];
        for (int i = 0; i < word.length(); i++) {
            guessedWord[i] = '_'; // Alle Buchstaben werden zu Beginn als _ angezeigt
        }

        // Maximale Anzahl an Fehlversuchen (z. B. 6)
        int maxAttempts = 6;
        int attemptsLeft = maxAttempts;
        String guessedLetters = ""; // Verfolgt die bereits geratenen Buchstaben

        Scanner scanner = new Scanner(System.in);

        // Das Spiel läuft, bis das Wort erraten wurde oder die Versuche aufgebraucht sind
        while (attemptsLeft > 0) {
            // Zeige den aktuellen Stand des Wortes und die Fehlversuche an
            System.out.println("\nAktuelles Wort: " + String.valueOf(guessedWord));
            System.out.println("Bereits geratene Buchstaben: " + guessedLetters);
            System.out.println("Versuche übrig: " + attemptsLeft);
            System.out.print("Gib einen Buchstaben oder das ganze Wort ein: ");
            String input = scanner.next();

            // Überprüfen, ob der Benutzer das ganze Wort eingibt
            if (input.length() == word.length()) {
                if (input.equalsIgnoreCase(word)) {
                    System.out.println("Herzlichen Glückwunsch! Du hast das gesamte Wort '" + word + "' erraten!");
                    break;
                } else {
                    attemptsLeft--; // Falsch geratenes Wort verringert die Versuche
                    System.out.println("Das ganze Wort ist falsch!");
                    continue;
                }
            }

            // Prüfen, ob der Benutzer nur einen einzelnen Buchstaben eingibt
            if (input.length() != 1) {
                System.out.println("Bitte gib nur einen einzelnen Buchstaben oder das gesamte Wort ein.");
                continue;
            }

            char guess = input.toLowerCase().charAt(0);

            // Überprüfen, ob der Buchstabe bereits geraten wurde
            if (guessedLetters.indexOf(guess) != -1) {
                System.out.println("Dieser Buchstabe wurde schon geraten. Versuch es mit einem anderen.");
                continue;
            }

            guessedLetters += guess; // Füge den geratenen Buchstaben zu den bereits geratenen hinzu

            // Überprüfe, ob der Buchstabe im Wort enthalten ist
            boolean correctGuess = false;
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == guess) {
                    guessedWord[i] = guess; // Aktualisiere das erratene Wort
                    correctGuess = true;
                }
            }

            // Wenn der Buchstabe falsch ist, verringere die verbleibenden Versuche
            if (!correctGuess) {
                attemptsLeft--;
                System.out.println("Falsch! Der Buchstabe " + guess + " ist nicht im Wort.");
            }

            // Überprüfe, ob das Wort vollständig erraten wurde
            if (String.valueOf(guessedWord).equals(word)) {
                System.out.println("\nHerzlichen Glückwunsch! Du hast das Wort '" + word + "' erraten.");
                break;
            }
        }

        // Wenn die Versuche aufgebraucht sind, verliere das Spiel
        if (attemptsLeft == 0) {
            System.out.println("\nLeider hast du verloren. Das Wort war: " + word);
        }

        scanner.close();
    }
}

