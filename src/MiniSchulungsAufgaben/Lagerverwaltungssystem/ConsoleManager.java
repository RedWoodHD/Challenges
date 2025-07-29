package MiniSchulungsAufgaben.Lagerverwaltungssystem;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static MiniSchulungsAufgaben.Lagerverwaltungssystem.Main.*;

public class ConsoleManager
{
    public static String readString(String output)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println(output);
            String userInput = scanner.nextLine();
            if (userInput.matches("^[a-zA-Z0-9 \\-]{1,22}$"))
            {
                return userInput;

            }
            else
            {
                System.out.println("--------------------------------------");
                System.out.println(cyan+"Folgende Regeln für den Namen: "+reset);
                System.out.println(red+"Buchstaben und Zahlen.");
                System.out.println("Sonderzeichen: Leerzeichen und Minus.");
                System.out.println("Länge: 1-22."+reset);
                System.out.println("-------------------------------------");
                return readString(output);
            }
        } catch (NoSuchElementException e)
        {
            System.out.println(red + "Mach das nicht! Beende Programm!" + reset);
            System.exit(0); // ❗Programm wird sofort beendet!
            return null;

        }
    }
    public static int readInt(String output)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println(output);
            return scanner.nextInt();
        } catch (InputMismatchException e){
            System.out.println(red+"❗Nur Zahlen verwenden❗"+reset);
            return readInt(output);
        }
        catch (NoSuchElementException e)
        {
            System.out.println(red + "Mach das nicht! Beende Programm!" + reset);
            System.exit(0); // ❗Programm wird sofort beendet!
            return 0;
        }
    }

    public static void printInventory(List<Product> inventoryList)
    {
        //═╬ ╬ ╔═ ╩ ║
        System.out.println("");
        System.out.println("╔════════════════════════════════════════╗");
        System.out.println("║   Produkt:               Anzahl:       ║");
        for (Product product : inventoryList)
        {
            System.out.print("║   " + product.getName());
            for (int i = 0; i < 23 - product.getName().length(); i++) // Produkt Name MAXIMAL 23 Buchstaben sonnst formatierung Kaputt Menge 13 zu hoch
            {
                System.out.print(" ");
            }
            System.out.print(product.getAmount());
            int spaces = String.valueOf(product.getAmount()).length();
            for (int i = 0; i < 14 - spaces; i++)
            {
                System.out.print(" ");
            }
            System.out.println("║");
        }
        System.out.println("║                                        ║");
        System.out.println("╚════════════════════════════════════════╝");
    }
}
