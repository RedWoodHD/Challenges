package MiniGames.TikTakToe;

/**
 * Diese Klasse representiert einen Spieler.
 */
public class Player
{
    String name;
    String symbole;

    public String getName()
    {
        return name;
    }

    public Player setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getSymbole()
    {
        return symbole;
    }

    public Player setSymbole(String symbole)
    {
        this.symbole = symbole;
        return this;
    }
}
