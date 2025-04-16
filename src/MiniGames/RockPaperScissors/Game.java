package MiniGames.RockPaperScissors;

import java.util.Random;
import java.util.Scanner;

public class Game
{
    public static void start()
    {
        String red = "\u001B[31m";
        String green = "\u001B[32m";
        String yellow = "\u001B[33m";
        String blue = "\u001B[34m";
        String bold = "\u001B[1m";
        String underlined = "\u001B[4m";
        String inverse = "\u001B[7m";
        String cyanBackground = "\u001B[46m";
        String blink = "\u001B[5m";
        String reset = "\u001B[0m"; // Zurücksetzen auf Standardfarbe

        // Beispielausgabe in verschiedenen Farben
//        System.out.println(red + underlined + "Dies ist roter Text!" + reset);
//        System.out.println(green + inverse + "Dies ist grüner Text!" + reset);
//        System.out.println(yellow + blink + "Dies ist gelber Text!" + reset);
//        System.out.println(blue + "Dies ist blauer Text!" + reset);
//        System.out.println("Dies ist normaler Text, keine Farbe.");

        int userCount = 0;
        int comCount = 0;
        System.out.println("Welcome to Rock Paper Scissors");


        while (true)
        {
            System.out.println("You: "+userCount+" \t Com: "+comCount);
            int userChoice = askForChoice();
            Random rand = new Random();
            int comChoice = rand.nextInt(3);
            boolean userWin = false;

//            Rock x (Rock, Paper, Scissors)
            if (userChoice == 0 && comChoice == 0)
            {
                System.out.println("\uD83E\uDEA8 vs \uD83E\uDEA8");
                System.out.println("it's a draw!");
            }
            if (userChoice == 0 && comChoice == 1)
            {
                System.out.println("\uD83E\uDEA8 vs \uD83D\uDCC4!");
                System.out.println("You lose!");
                comCount++;
            }
            if (userChoice == 0 && comChoice == 2)
            {
                System.out.println("\uD83E\uDEA8 vs ✂");
                System.out.println("You won!");
                userCount++;
            }
//            Paper x (Rock, Paper, Scissors)
            if (userChoice == 1 && comChoice == 0)
            {
                System.out.println("\uD83D\uDCC4 vs \uD83E\uDEA8");
                System.out.println("You win!");
                userCount++;
            }
            if (userChoice == 1 && comChoice == 1)
            {
                System.out.println("\uD83D\uDCC4 vs \uD83D\uDCC4");
                System.out.println("it's a draw!");
            }
            if (userChoice == 1 && comChoice == 2)
            {
                System.out.println("\uD83D\uDCC4 vs ✂");
                System.out.println("You lose!");
                comCount++;
            }

//            Scissors x (Rock, Paper, Scissors)
            if (userChoice == 2 && comChoice == 0)
            {
                System.out.println("✂ vs \uD83E\uDEA8");
                System.out.println("You lose!");
                comCount++;
            }
            if (userChoice == 2 && comChoice == 1)
            {
                System.out.println("✂ vs \uD83D\uDCC4");
                System.out.println("You win!");
                userCount++;
            }
            if (userChoice == 2 && comChoice == 2)
            {
                System.out.println("✂ vs ✂");
                System.out.println("its a draw!");
            }
        }
    }

    private static int askForChoice()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Choose your attack (rock,paper,scissors): ");
        String user = scanner.nextLine();
        System.out.println();
        switch (user)
        {
            case "rock":
                return 0;
            case "paper":
                return 1;
            case "scissors":
                return 2;
            default:
                System.out.println("Wrong input");
        }
        return 666;
    }
}
