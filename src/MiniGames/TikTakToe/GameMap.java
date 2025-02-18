package MiniGames.TikTakToe;

import java.util.ArrayList;
import java.util.List;

/**
 * Diese Klasse representiert ein Spielfeld.
 */
public class GameMap
{
    static private final List<String> positionen= new ArrayList<>();


    public GameMap()
    {
        positionen.add(" ");
        positionen.add(" ");
        positionen.add(" ");
        positionen.add(" ");
        positionen.add(" ");
        positionen.add(" ");
        positionen.add(" ");
        positionen.add(" ");
        positionen.add(" ");
    }

    /**
     * Diese Methode gibt das Spielfeld auf der Konsole aus.
     */
    public static void printMap()
    {
        System.out.println(" "+positionen.get(0)+ " │ "+positionen.get(1)+ " │ "+positionen.get(2)+" ");
        System.out.println("───┼───┼───");
        System.out.println(" "+positionen.get(3)+ " │ "+positionen.get(4)+" │ "+positionen.get(5)+" ");
        System.out.println("───┼───┼───");
        System.out.println(" "+positionen.get(6)+" │ "+positionen.get(7)+" │ "+positionen.get(8)+" ");
// ┼,┬,┴,├,┤,═,║,┌,┐,└,┘,─,│,
//╔════════════════════╗
//╚════════════════════╝
    }

    public String getPosition(int index){
        return positionen.get(index);
    }
    public void setPositionen(int index, String symbole){
        positionen.remove(index);
        positionen.add(index,symbole);
    }

}
