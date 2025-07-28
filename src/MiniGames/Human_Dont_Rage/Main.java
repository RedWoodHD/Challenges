package MiniGames.Human_Dont_Rage;
import MiniGames.Human_Dont_Rage.Logic.Game;

import java.util.ConcurrentModificationException;
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("");
        try
        {
            Game.launch();
        } catch (ConcurrentModificationException e)
        {
            System.out.println("Spiel wird beendet!");
        }
    }
}
