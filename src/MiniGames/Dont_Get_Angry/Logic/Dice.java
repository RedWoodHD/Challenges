package MiniGames.Dont_Get_Angry.Logic;

import MiniGames.Dont_Get_Angry.Console.Input;

import java.util.Random;

/**
 * Diese Klasse stellt einen Würfel da mit dem man zufällige Zahlen generieren kann.
 *
 * @author EGA
 */
public class Dice
{
    /**
     * Diese Methode gibt eine Zufällige {@link int Zahl} von 1 bis 6 zurück.
     *
     * @return Zufällige {@link int Zahl} von 1 - 6
     *
     * @author EGA
     */
    public static int roll()
    {
        Input.getString("");
        int result = 0;
        Random rand = new Random();
        result = rand.nextInt(6) + 1;
        return result;
    }

    /**
     * Diese Methode ist zum Testen da sie liefert mit einer höheren wahrscheinlichkeit eine 6.
     *
     * @return eine gewürfelte Zahl von 1 bis 6.
     *
     * @author EGA
     */
    public static int testRoll()
    {
        Input.getString("");
        int result = 0;
        Random rand = new Random();
        result = rand.nextInt(6) + 1;
        if (rand.nextInt(2) + 1 == 1)
        {
            System.out.println("New 6");
            return 6;
        }
        return result;
    }
}
