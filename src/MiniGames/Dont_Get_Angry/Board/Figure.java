package MiniGames.Dont_Get_Angry.Board;

public class Figure
{
    String operator;
    int number;
    int position;
    boolean insideSpawn = true;
    boolean insideGoal = false;

    public Figure(String operator, int number)
    {
        this.operator = operator;
        this.number = number;
    }

    public boolean isInsideGoal()
    {
        return insideGoal;
    }

    public Figure setInsideGoal(boolean insideGoal)
    {
        this.insideGoal = insideGoal;
        return this;
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

    public boolean isInsideSpawn()
    {
        return insideSpawn;
    }

    public Figure setInsideSpawn(boolean insideSpawn)
    {
        this.insideSpawn = insideSpawn;
        return this;
    }


}
