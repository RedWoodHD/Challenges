package MiniGames.Human_Dont_Rage;

import MiniGames.Human_Dont_Rage.Board.Figure;

/**
 * Diese Klasse representiert einen Spieler.
 * @author EGA
 */
public class Player
{
    String name;
    Figure[] figureArray;
    int playerNumber;
    int spawnField;
    int[] path;

    public Player(String name, Figure[] figureArray, int playerNumber, int[] path)
    {
        this.name = name;
        this.figureArray = figureArray;
        this.playerNumber = playerNumber;
        this.path = path;
    }

    public int[] getPath()
    {
        return path;
    }

    public int getSpawnField()
    {
        return spawnField;
    }

    public Player setSpawnField(int spawnField)
    {
        this.spawnField = spawnField;
        return this;
    }

    public String getName()
    {
        return name;
    }
    public Player setName(String name)
    {
        this.name = name;
        return this;
    }
    public int getPlayerNumber()
    {
        return playerNumber;
    }

    public Figure[] getFigureArray()
    {
        return figureArray;
    }
}
