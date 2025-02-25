package MiniGames.Connect_Four;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput
{
    public static String readString(String output)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.print(output);
            return scanner.nextLine();
        } catch (NoSuchElementException e)
        {
            System.out.println("Falsche Eingabe");
            return null;
        }
    }
    public static int readInteger(String output)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.print(output);
            int input = scanner.nextInt();
            if (input >7 || input < 1){
                throw new NoSuchElementException();
            }
            return input;
        } catch (IllegalStateException e)
        {
            System.out.println("Falsche Eingabe");
            return readInteger(output);
        }
        catch (NoSuchElementException e){
            System.out.println("Falsche Eingabe, nochmal Probieren!");
            return readInteger(output);
        }
    }
}
