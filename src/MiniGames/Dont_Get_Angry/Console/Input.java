package MiniGames.Dont_Get_Angry.Console;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input
{
    public static String getString(String print)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.print(print);
        return scanner.nextLine();
    }

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
