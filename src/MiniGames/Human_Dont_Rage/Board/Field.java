package MiniGames.Human_Dont_Rage.Board;

/**
 * Diese Klasse representiert ein Spielfeld auf dem sich eine {@link Figure} befinden kann.
 * @author EGA
 */
public class Field
{
    Figure figure;

    public Figure getFigure()
    {
        return figure;
    }

    public Field setFigure(Figure figure)
    {
        this.figure = figure;
        return this;
    }
}
