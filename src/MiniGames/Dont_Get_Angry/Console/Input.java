package MiniGames.Dont_Get_Angry.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Diese Klasse dient dazu Methoden bereitzustellen, die den Benutzer auffordern etwas in die Konsole einzugeben.
 * @author EGA
 */
public class Input
{
    /**
     * Diese Methode fragt den benutzer nach einem {@link String Text}.
     * @param print Der {@link String Text} der vorher als Nachricht ausgegeben werden soll.
     * @return Der eingegebene {@link String Text} vom Benutzer.
     * @author EGA
     */
    public static String getString(String print)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(print);
        return scanner.nextLine();
    }

    /**
     * Diese Methode fragt den benutzer nach einer Zahl zwischen 1 - 4.
     * @param print Der {@link String Text} der vorher als Nachricht ausgegeben werden soll.
     * @return Die eingegebene {@link int Zahl} vom Benutzer.
     * @author EGA
     */
    public static int getInt(String print)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.print(print);
            int number = scanner.nextInt();
            if (number <= 4 && number >= 1)
            {
                return number;
            }
            else
            {
                throw new InputMismatchException();
            }
        } catch (InputMismatchException e)
        {
            System.out.println("Bitte geben sie nur Zahlen von 1 - 4 ein");
            return getInt(print);
        }
    }
}
