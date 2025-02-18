package MiniGames.TikTakToe;

/**
 * Diese Klasse representiert das Spiel und hat eine {@link #startGame()} Methode um das Spiel zu starten.
 * @author EGA
 */
public class TikTakToe
{
    /**
     * Diese Methode Starte das Spiel und erstellt sowohl die nötigen {@link Player Spieler} als auch das {@link GameMap Spielfeld}.
     * @author EGA
     */
    public static void startGame()
    {
//        ▼▽△▲
        Player playerOne = createPlayer("X");
        System.out.println();
        Player playerTwo = createPlayer("0");
        GameMap gameMap = new GameMap();
        GameMap.printMap();
        playGame(playerOne, playerTwo, gameMap);
    }

    /**
     * Diese Methode führt sich selber, solange aus, bis das Spiel zu Ende ist.<br>
     * Diese Methode wird Rekursiv ausgeführt.
     *
     * @param playerOne {@link Player Spieler} Eins.
     * @param playerTwo {@link Player Spieler} Zwei.
     * @param gameMap   Das {@link GameMap Spielfeld}.
     *
     * @return {@link false} wenn das Spiel beendet wurde.
     *
     * @author EGA
     */
    private static boolean playGame(Player playerOne, Player playerTwo, GameMap gameMap)
    {
//        Erstelle die Spieler
        String playerOneSymbole = playerOne.getSymbole();
        String playerTwoSymbole = playerTwo.getSymbole();
//        Prüfe, ob das gewünschte Feld vom Benutzer schon besetzt ist.
        int playerOneMove = UserInput.askForInteger(playerOne.getName() + " Geben Sie ihr gewünschtes Feld ein: ");
        while (gameMap.getPosition(playerOneMove - 1).equalsIgnoreCase(playerOneSymbole) || gameMap.getPosition(playerOneMove - 1).equalsIgnoreCase(playerTwoSymbole))
        {
            System.out.println("Diese Feld ist schon besetzt!");
            playerOneMove = UserInput.askForInteger(playerOne.getName() + " Geben Sie ihr gewünschtes Feld erneut ein: ");
        }
//        Setze die Position und gebe den neuen Spielstand aus.
        gameMap.setPositionen(playerOneMove - 1, playerOneSymbole);
        GameMap.printMap();
//        Prüfe, ob das Spiel zu Ende ist.
        if (checkForWin(gameMap, playerOneSymbole))
        {
            System.out.println(playerOne.getName() + " hat gewonnen!");
            return false;
        }
        if (checkForDraw(gameMap, playerOneSymbole, playerTwoSymbole))
        {
            System.out.println("Unentschieden!");
            return false;
        }
//        Prüfe, ob das gewünschte Feld vom Benutzer schon besetzt ist.
        int playerTwoMove = UserInput.askForInteger(playerTwo.getName() + " Geben Sie ihr gewünschtes Feld ein: ");
        while (gameMap.getPosition(playerTwoMove - 1).equalsIgnoreCase(playerOneSymbole) || gameMap.getPosition(playerTwoMove - 1).equalsIgnoreCase(playerTwoSymbole))
        {
            System.out.println("Diese Feld ist schon besetzt!");
            playerTwoMove = UserInput.askForInteger(playerTwo.getName() + " Geben Sie ihr gewünschtes Feld erneut ein: ");
        }
//        Setze die Position und gebe den neuen Spielstand aus.
        gameMap.setPositionen(playerTwoMove - 1, playerTwoSymbole);
        GameMap.printMap();
//        Prüfe, ob das Spiel zu Ende ist.
        if (checkForWin(gameMap, playerTwoSymbole))
        {
            System.out.println(playerTwo.getName() + " hat gewonnen!");
            return false;
        }
        if (checkForDraw(gameMap, playerOneSymbole, playerTwoSymbole))
        {
            System.out.println("Unentschieden!");
            return false;
        }
//        Starte die Methode rekursiv neu.
        return playGame(playerOne, playerTwo, gameMap);
    }

    /**
     * Diese Methode überprüft, ob das Spiel ein unentschieden ist.
     *
     * @param gameMap          Die Map in der die Positionen gespeichert sind.
     * @param playerOneSymbole Das Spiel Symbole vom {@link Player ersten Spieler}, nach dem geprüft wird.
     * @param playerTwoSymbole Das Spiel Symbole vom {@link Player zweiten Spieler}, nach dem geprüft wird.
     *
     * @return {@link true} bei einem Unentschieden oder {@link false} wenn das Spiel kein Unentschieden ist.
     *
     * @author EGA
     */
    private static boolean checkForDraw(GameMap gameMap, String playerOneSymbole, String playerTwoSymbole)
    {
        int count = 0;
        for (int i = 0; i < 9; i++)
        {
            if (gameMap.getPosition(i).equalsIgnoreCase(playerOneSymbole) || gameMap.getPosition(i).equalsIgnoreCase(playerTwoSymbole))
            {
                count++;
            }
        }
        if (count >= 9)
        {
            return true;
        }
        return false;
    }

    /**
     * Diese Methode überprüft, ob das Spiel gewonnen wurde.
     *
     * @param gameMap Die Map in der die Positionen stehen.
     * @param symbole Das Symbole nach dem geprüft werden soll.
     *
     * @return {@link true} wenn das Spiel gewonnen wurde oder {@link false} wenn das Spiel nicht gewonnen wurde.
     *
     * @author EGA
     */
    private static boolean checkForWin(GameMap gameMap, String symbole)
    {
        if (gameMap.getPosition(0).equals(symbole) && gameMap.getPosition(1).equals(symbole) && gameMap.getPosition(2).equals(symbole))
        {
            return true;
        }
        if (gameMap.getPosition(0).equals(symbole) && gameMap.getPosition(4).equals(symbole) && gameMap.getPosition(8).equals(symbole))
        {
            return true;
        }
        if (gameMap.getPosition(0).equals(symbole) && gameMap.getPosition(3).equals(symbole) && gameMap.getPosition(6).equals(symbole))
        {
            return true;
        }
        if (gameMap.getPosition(1).equals(symbole) && gameMap.getPosition(4).equals(symbole) && gameMap.getPosition(7).equals(symbole))
        {
            return true;
        }
        if (gameMap.getPosition(2).equals(symbole) && gameMap.getPosition(4).equals(symbole) && gameMap.getPosition(6).equals(symbole))
        {
            return true;
        }
        if (gameMap.getPosition(2).equals(symbole) && gameMap.getPosition(5).equals(symbole) && gameMap.getPosition(8).equals(symbole))
        {
            return true;
        }
        if (gameMap.getPosition(3).equals(symbole) && gameMap.getPosition(4).equals(symbole) && gameMap.getPosition(5).equals(symbole))
        {
            return true;
        }
        return gameMap.getPosition(6).equals(symbole) && gameMap.getPosition(7).equals(symbole) && gameMap.getPosition(8).equals(symbole);
    }

    /**
     * Diese Methode erstellt einen {@link Player Spieler} und fragt nach dem {@link Player#name Benutzernamen}.
     *
     * @param symbole Der String der als Spiel Symbol in die Felder platziert wird.
     *
     * @return Den Spieler fertigen{@link Player Spieler}.
     *
     * @Author EGA
     */
    private static Player createPlayer(String symbole)
    {
        Player player = new Player();
        player.setName(UserInput.askForString("Bitte geben Sie Ihren Username ein: "));
        player.setSymbole(symbole);
        System.out.println("Ihr Name ist: " + player.getName());
        System.out.println("Ihr Symbol ist: " + player.getSymbole());
        return player;
    }
}
