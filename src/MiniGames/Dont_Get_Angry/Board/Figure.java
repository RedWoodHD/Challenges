package MiniGames.Dont_Get_Angry.Board;

public class Figure
{
    String operator;
    int number;
    int position;

    public Figure(String operator, int number)
    {
        this.operator = operator;
        this.number = number;
    }

    public String getOperator()
    {
        return operator;
    }

    public Figure setOperator(String operator)
    {
        this.operator = operator;
        return this;
    }

    public int getNumber()
    {
        return number;
    }

    public Figure setNumber(int number)
    {
        this.number = number;
        return this;
    }

    public int getPosition()
    {
        return position;
    }

    public Figure setPosition(int position)
    {
        this.position = position;
        return this;
    }
}
