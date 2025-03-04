package MiniGames.Connect_Four;

public class ConnectFour
{

    public static void start()
    {
        Player firstPlayer = makePlayer("\u001B[36m"+"X"+"\u001B[0m");
        Player secondPlayer = makePlayer("\u001B[35m"+"0"+"\u001B[0m");
        String[][] fieldPosition = new String[6][7];
        Console_Output.printMap(fieldPosition);
        while (true)
        {
            firstPlayer.setAction(UserInput.readInteger(firstPlayer.getName() + " geben sie Ihren Zug ein: "));
            fieldPosition = Checker.gravityCheck(fieldPosition,firstPlayer);
            if (Checker.winnersCheck(fieldPosition,firstPlayer))
            {
                Console_Output.printMap(fieldPosition);
                System.out.println("WINNER: "+firstPlayer.getName());
                return;
            }
            Console_Output.printMap(fieldPosition);
            secondPlayer.setAction(UserInput.readInteger(secondPlayer.getName() + " geben sie Ihren Zug ein: "));
            fieldPosition = Checker.gravityCheck(fieldPosition, secondPlayer);
            if (Checker.winnersCheck(fieldPosition,secondPlayer))
            {
                Console_Output.printMap(fieldPosition);
                System.out.println("WINNER: "+secondPlayer.getName());
                return;
            }
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
