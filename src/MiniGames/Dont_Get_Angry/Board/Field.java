package MiniGames.Dont_Get_Angry.Board;

import MiniGames.Dont_Get_Angry.Definition.Type;

public class Field
{
    Figure figure;
    Type type;

    public Field(Type type)
    {
        this.type = type;
    }
    public Type getType()
    {
        return type;
    }

    public Field setType(Type type)
    {
        this.type = type;
        return this;
    }

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
