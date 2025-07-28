package MiniSchulungsAufgaben.Lagerverwaltungssystem;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import static MiniSchulungsAufgaben.Lagerverwaltungssystem.Main.red;
import static MiniSchulungsAufgaben.Lagerverwaltungssystem.Main.reset;

public class ConsoleManager
{
    public static String readString(String output)
    {
        try
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println(output);
            return scanner.nextLine();
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
        } catch (NoSuchElementException e)
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
