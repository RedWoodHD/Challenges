package MiniSchulungsAufgaben.Lagerverwaltungssystem;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static java.awt.Color.blue;

public class Main
{
    static String red = "\u001B[31m";
    static String green = "\u001B[32m";
    static String cyan = "\u001B[36m";
    static String reset = "\u001B[0m"; // Zurücksetzen auf Standardfarbe

    public static void main(String[] args) throws IOException // Muss Exception werfen für den FileWriter
    {
        File safeFile = FileManager.verifyOrCreateFile();
        List<Product> fullInventory = FileManager.reader(safeFile);
//        new FileWriter(safeFile, false).close();
        while (true)
        {
            int userInput = getUserInput(); // Benutzer nach eingabe Fragen
            switch (userInput)
            {
                case 1: //Einlagern
                    String productName = ConsoleManager.readString("Bitte geben Sie den Produktnamen ein: ");
                    int productAmount = ConsoleManager.readInt("Bitte geben Sie die Menge ein: ");
                    savingAndWriting(fullInventory, productName, productAmount, 1, safeFile);
                    break;
                case 2: //Auslagern
                    String productName2 = ConsoleManager.readString("Bitte geben Sie den Produktnamen ein: ");
                    if (searchForProduct(fullInventory, productName2) != -1)
                    {
                        int productAmount2 = ConsoleManager.readInt("Bitte geben Sie die Menge ein: ");
                        savingAndWriting(fullInventory, productName2, productAmount2, 2, safeFile);
                    }
                    savingAndWriting(fullInventory, "Egal", -99999999, 2, safeFile);
                    break;
                case 3: //Löschen
                    String productName3 = ConsoleManager.readString("Bitte geben Sie den Produktnamen ein, den sie löschen möchten: ");
                    int productIndexForDelete = searchForProduct(fullInventory, productName3);
                    if (productIndexForDelete != -1)
                    {
                        String safeNameForDeletion = fullInventory.get(productIndexForDelete).getName();
                        fullInventory.remove(productIndexForDelete);
                        savingAndWriting(fullInventory, "Egal", -99999999, 3, safeFile);
//                    FileManager.clearFile(safeFile);
                        System.out.println(red + "'" + safeNameForDeletion + reset + "' wurde erfolgreich gelöscht.");
                        break;
                    } else
                    {
                        System.out.println("Produkt: '" + red + productName3 + reset + "' wurde nicht gefunden.");;
                    }
                    break;
                case 4: //Inventar anzeigen
                    fullInventory = FileManager.reader(safeFile);
                    ConsoleManager.printInventory(fullInventory);
                    break;
                case 5: //Suchen
                    String productToSearch = ConsoleManager.readString("Bitte geben Sie den Produktnamen ein, den Sie suchen wollen: ");
                    int productIndex = searchForProduct(fullInventory, productToSearch);
                    if (productIndex != -1)
                    {
                        System.out.println("Produkt: '" + green + fullInventory.get(productIndex).getName() + reset + "' wurde erfolgreich gefunden.");
                        System.out.println("Anzahl: " + cyan + fullInventory.get(productIndex).getAmount() + reset);
                    }
                    else
                    {
                            System.out.println("Produkt: '" + red + productToSearch + reset + "' wurde nicht gefunden.");
                    }
                    break;
                case 6: //Exit
                    return;
            }
        }
    }

    private static int getUserInput()
    {
        System.out.println("Wählen sie aus:   1) Einlagern \t 2) Auslagern \t 3) Löschen \t 4) Inventar anzeigen \t 5) Suchen \t 6) Exit");

        try
        {
            int userAction = ConsoleManager.readInt("");

            if (userAction < 1 || userAction > 6)
            {
                throw new InputMismatchException();
            }

            return userAction;
        } catch (InputMismatchException e)
        {
            System.out.println(red+"Bitte geben Sie nur die Angegebenen Zahlen ein!"+reset);
            return 0;
        }
    }

    private record Result(int userAction, String productName, int productAmount)
    {

    }

    private static int searchForProduct(List<Product> fullInventory, String productName)
    {
        // Durchlauf: Produkt suchen
        int counter = 0;
        for (Product p : fullInventory)
        {
            if (p != null && p.getName().equals(productName))
            {
                return counter;
            }
            counter++;
        }
        return -1;
    }

    private static void savingAndWriting(List<Product> fullInventory, String productName, int productAmount, int userAction, File safeFile) throws IOException
    {
        if (userAction == 3) //Löschen
        {
            // Liste vollständig neu schreiben
            new FileWriter(safeFile, false).close();
            for (
                    Product p : fullInventory)
            {
                if (p != null)
                {
                    FileManager.write(p.getName(), p.getAmount(), safeFile);
                }
            }
            return;
        }
        // Durchlauf: Produkt suchen
        int foundIndex = searchForProduct(fullInventory, productName);
        if (foundIndex >= 0)
        {
            Product userProduct = fullInventory.get(foundIndex);

            if (userAction == 1)
            {
                userProduct.setAmount(userProduct.getAmount() + productAmount);
            }
            if (userAction == 2)
            {
                if (userProduct.getAmount() - productAmount >= 0)
                {
                    userProduct.setAmount(userProduct.getAmount() - productAmount);
                }
            }

        }
        // Falls nicht gefunden: hinzufügen
        if (foundIndex == -1 && userAction == 1)
        {
            fullInventory.add(new Product(productName, productAmount));
        }
        else if (foundIndex == -1 && userAction == 2)
        {
            System.out.println(red+"Produkt existiert nicht."+reset);
        }

        // Liste vollständig neu schreiben
        new FileWriter(safeFile, false).close();
        for (
                Product p : fullInventory)
        {
            if (p != null)
            {
                FileManager.write(p.getName(), p.getAmount(), safeFile);
            }
        }
    }
}
