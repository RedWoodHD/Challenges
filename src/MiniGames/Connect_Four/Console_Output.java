package MiniGames.Connect_Four;

import java.util.Scanner;

public class Console_Output
{
    public static void printMap(String[][] fieldPosition){

        System.out.println("  1   2   3   4   5   6   7");
        System.out.println("╔═══╦═══╦═══╦═══╦═══╦═══╦═══╗");
        for (int i = 0; i < 6; i++)
            {
                for (int j = 0; j < 7; j++)
                {
                    if (fieldPosition[i][j] != null)
                    {
                        System.out.print("║ " + fieldPosition[i][j] + " ");
                    } else System.out.print("║   ");

                }
                System.out.println("║");
                if (i !=5)
                {
                    printMiddle();
                }
            }
        System.out.println("╚═══╩═══╩═══╩═══╩═══╩═══╩═══╝");
    }

    private static void printMiddle(){
        System.out.println("╠═══╬═══╬═══╬═══╬═══╬═══╬═══╣");
    }
}
