package MiniGames.Dont_Get_Angry;

import MiniGames.Dont_Get_Angry.Board.Figure;

public class Player
{
    String name;
    Figure[] figureArray;
    int playerNumber;

    public Player(String name, Figure[] figureArray, int playerNumber)
    {
        this.name = name;
        this.figureArray = figureArray;
        this.playerNumber = playerNumber;
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
    public Player setPlayerNumber(int playerNumber)
    {
        this.playerNumber = playerNumber;
        return this;
    }

    public Figure[] getFigureArray()
    {
        return figureArray;
    }

    public Player setFigureArray(Figure[] figureArray)
    {
        this.figureArray = figureArray;
        return this;
    }
}
