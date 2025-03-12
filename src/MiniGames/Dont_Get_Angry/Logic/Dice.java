package MiniGames.Dont_Get_Angry.Logic;

import MiniGames.Dont_Get_Angry.Console.Input;

import java.util.Random;

public class Dice
{
    public static int roll()
    {
        Input.getString("");
        int result = 0;
        Random rand = new Random();
        result = rand.nextInt(6)+1;
        return result;
    }
}
