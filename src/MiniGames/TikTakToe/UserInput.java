package MiniGames.TikTakToe;

import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Diese Klasse liefert Methoden für eine einfache Benutzereingabe.
 * @author EGA
 */

public class UserInput
{
    /**
     * Diese Methode fragt den Benutzer nach einer {@link Integer Zahl}.
     * @param textToAsk Der {@link String Text} der auf der Konsole vor dem Einlesen ausgeben werden soll.
     * @return Die Eingabe vom Benutzer.
     * @Author EGA
     */
    public static String askForString(String textToAsk){
        Scanner scanner = new Scanner(System.in);
        System.out.println(textToAsk);
        try
        {
            return scanner.nextLine();
        } catch (NoSuchElementException | IllegalStateException e){
            System.out.println("Wrong Input!");
            return null;
        }
    }

    /**
     * Diese Methode fragt den Benutzer nach einem {@link String Text}.
     * @param textToAsk Der {@link String Text} der auf der Konsole vor dem Einlesen ausgeben werden soll.
     * @return Die Eingabe vom Benutzer.
     * @Author EGA
     */
    public static int askForInteger(String textToAsk){
        Scanner scanner = new Scanner(System.in);
        System.out.println(textToAsk);
        try
        {
            return scanner.nextInt();
        }
        catch (NoSuchElementException | IllegalStateException e){
            System.out.println("Wrong Input!");
            return 0;
        }
    }
}
