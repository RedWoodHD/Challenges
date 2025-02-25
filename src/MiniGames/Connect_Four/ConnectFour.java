package MiniGames.Connect_Four;

public class ConnectFour
{

    public static void start()
    {
        Player firstPlayer = makePlayer("X");
        Player secondPlayer = makePlayer("0");
        String[][] fieldPosition = new String[6][7];
        Console_Output.printMap(fieldPosition);
        while (true)
        {
            firstPlayer.setAction(UserInput.readInteger(firstPlayer.getName() + " geben sie Ihren Zug ein: "));
            secondPlayer.setAction(UserInput.readInteger(secondPlayer.getName() + " geben sie Ihren Zug ein: "));
            fieldPosition[0][firstPlayer.getAction() - 1] = firstPlayer.getOperator();
            Console_Output.printMap(fieldPosition);
            fieldPosition[0][secondPlayer.getAction() - 1] = secondPlayer.getOperator();
            Console_Output.printMap(fieldPosition);
        }
    }

    private static Player makePlayer(String operator)
    {
        Player player = new Player();
        player.setName(UserInput.readString("Geben Sie Ihren Namen ein: "));
        player.setOperator(operator);
        return player;
    }
}
