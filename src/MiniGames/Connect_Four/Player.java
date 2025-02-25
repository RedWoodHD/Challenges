package MiniGames.Connect_Four;

public class Player
{
    private String name;
    private int action;
    private String operator;


    public String getName()
    {
        return name;
    }

    public Player setName(String name)
    {
        this.name = name;
        return this;
    }

    public int getAction()
    {
        return action;
    }

    public Player setAction(int action)
    {
        this.action = action;
        return this;
    }

    public String getOperator()
    {
        return operator;
    }

    public Player setOperator(String operator)
    {
        this.operator = operator;
        return this;
    }
}
