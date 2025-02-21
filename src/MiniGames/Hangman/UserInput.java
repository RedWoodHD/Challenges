package MiniGames.Hangman;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class UserInput
{
    public static String readString(String textToPrint)
    {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(textToPrint);
            return scanner.nextLine();
        }
        catch (IllegalStateException e){
            System.out.println("Wrong Input");
            return "";
        } catch (NoSuchElementException e){
            System.out.println("NoSuchElementException!");
            return "";
        }
    }

    public static String readNormalLetterText(String textToPrint)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.println(textToPrint);
            String userText = scanner.nextLine();
            if (userText.matches("[A-Za-z]+")){
                return userText;
            }else throw new IllegalStateException();
        } catch (IllegalStateException e){
            System.out.println("Wrong Input, try again!");
            return readNormalLetterText(textToPrint);
        } catch (NoSuchElementException e){
            System.out.println("NoSuchElementException!");
            return "";
        }
    }
    public static char readOneNormalChar(String textToPrint)
    {
        Scanner scanner = new Scanner(System.in);
        try
        {
            System.out.println(textToPrint);
            String userText = scanner.nextLine();
            if (userText.matches("[a-zA-Z]{1}"))
            {
                return userText.charAt(0);
            }
            else throw new IllegalStateException();
        } catch (IllegalStateException e)
        {
            System.out.println("Wrong Input, try again!");
            return readOneNormalChar(textToPrint);
        } catch (NoSuchElementException e){
            System.out.println("NoSuchElementException!");
            return ' ';
        }
    }
}