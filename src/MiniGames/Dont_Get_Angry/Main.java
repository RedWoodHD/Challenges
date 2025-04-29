package MiniGames.Dont_Get_Angry;
import MiniGames.Dont_Get_Angry.Logic.Game;

import java.util.ConcurrentModificationException;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Game.start();
        } catch (ConcurrentModificationException e)
        {
            System.out.println("Spiel wird beendet!");
        }
    }
}
