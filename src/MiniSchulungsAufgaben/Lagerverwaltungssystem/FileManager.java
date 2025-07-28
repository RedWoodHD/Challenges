package MiniSchulungsAufgaben.Lagerverwaltungssystem;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileManager
{
    public static void clearFile(File file){
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file, false))) {
            System.out.println("Datei geleert.");
        } catch (IOException e) {
    System.out.println("Fehler beim Schreiben: " + e.getMessage());
}
    }
    public static void write (String text,Integer number, File file)
    {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(file, true))) {
            // 'true' bedeutet: Text wird angehängt, nicht überschrieben
            writer.write(text); // Schreibe den gewünschten Text in die Zeile
            writer.write(",");
            writer.write(number.toString());
            writer.newLine();  // neue Zeile
//            System.out.println("Text wurde erfolgreich geschrieben!");
            writer.flush();
        } catch (IOException e) {
            System.out.println("Fehler beim Schreiben: " + e.getMessage());
        }

    }
    public static List<Product> reader (File file){
        List<Product> productList = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {

                if (line.trim().isEmpty()){
                    continue; //Skip, wenn die Zeile leer ist.
                }
                try
                {

                    Scanner scanner = new Scanner(line);
                    scanner.useDelimiter(",");
                    if (scanner.hasNext())
                    {
                        String name = scanner.next().trim();
                        int number = scanner.nextInt();

                        productList.add(new Product(name, number));
                    }
                } catch (NoSuchElementException e)
                {
                    System.out.println("Fehler in der Zeile gefunden, lösche diese!");
                }
            }
        } catch (IOException e) {
            System.err.println("Fehler beim Lesen: " + e.getMessage());
        }

        return productList;
    }

    public static File verifyOrCreateFile()
    {
        String filePath = "src/MiniSchulungsAufgaben/Lagerverwaltungssystem/Lagerverwaltungssystem.txt";
        File file = new File(filePath);

        // Prüfen, ob Datei existiert

        if (!file.exists())
        {
            try
            {
                if (file.createNewFile())
                {
                    System.out.println("Datei wurde neu erstellt: " + filePath);
                }
            } catch (IOException e)
            {
                System.out.println("Fehler beim Erstellen der Datei: " + e.getMessage());
            }
        }
        return file;
    }

}
