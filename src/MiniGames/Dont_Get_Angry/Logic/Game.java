package MiniGames.Dont_Get_Angry.Logic;

import MiniGames.Dont_Get_Angry.Board.Field;
import MiniGames.Dont_Get_Angry.Board.Figure;
import MiniGames.Dont_Get_Angry.Console.Input;
import MiniGames.Dont_Get_Angry.Console.Output;
import MiniGames.Dont_Get_Angry.Factory.FieldFactory;
import MiniGames.Dont_Get_Angry.Player;
import java.util.ConcurrentModificationException;

/**
 * Diese Klasse representiert das Spiel, in dieser Wird das Spiel aufgebaut und durchgeführt.
 *
 * @author EGA
 */
public class Game
{
    /**
     * Diese Methode erstellt alle notwendigen Objekte und startet das Spiel.<br>
     * Die einzelnen Runden werden in einer anderen Methode behandelt.
     *
     * @author EGA
     */
    public static void launch()
    {
//        Create all Fields
        Field[] fieldArray = FieldFactory.createAllFields();
//        Create all Figures
        Figure[] figuresPOne = createFigureArray(1, "▲", "\033[31m");
        Figure[] figuresPTwo = createFigureArray(2, "■", "\033[36m");
        Figure[] figuresPThree = createFigureArray(3, "●", "\033[32m");
        Figure[] figuresPFour = createFigureArray(4, "♦", "\033[33m");
//        Set Spawn Figures
        setPositions(fieldArray, figuresPOne, 0, 1, 2, 3);
        setPositions(fieldArray, figuresPTwo, 4, 5, 6, 7);
        setPositions(fieldArray, figuresPThree, 8, 9, 10, 11);
        setPositions(fieldArray, figuresPFour, 12, 13, 14, 15);
//        Set player paths
        int[] p1Path = new int[]{0, 1, 2, 3, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59
        };
        int[] p2Path = new int[]{4, 5, 6, 7, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 60, 61, 62, 63
        };
        int[] p3Path = new int[]{8, 9, 10, 11, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 68, 69, 70, 71
        };
        int[] p4Path = new int[]{12, 13, 14, 15, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 64, 65, 66, 67
        };
//        Asking for Player Number
        int playerAmount = Input.getInt("Wie viele Spieler sind da: ");
//        Create first two players
        Player playerOne = new Player(Input.getString("\033[31m" + "Spieler eins geben Sie Ihren Namen ein: "+ "\033[0m"), figuresPOne, 1, p1Path);
        Player playerTwo = new Player("", figuresPTwo, 2, p2Path);
//        Create optional players
        Player playerThree = new Player("", figuresPThree, 3, p3Path);
        Player playerFour = new Player("", figuresPFour, 4, p4Path);
        Player[] allPlayers = new Player[]{playerOne, playerTwo, playerThree, playerFour};
        playerOne.setSpawnField(16);
        playerTwo.setSpawnField(26);
        playerThree.setSpawnField(46);
        playerFour.setSpawnField(36);
        if (playerAmount >= 2)
        {
            playerTwo.setName(Input.getString("\033[36m" + "Spieler zwei geben Sie Ihren Namen ein: "+ "\033[0m"));

        }
        if (playerAmount >= 3)
        {
            playerThree.setName(Input.getString("\033[32m" + "Spieler drei geben Sie Ihren Namen ein: "+ "\033[0m"));
        }
        if (playerAmount == 4)
        {
            playerFour.setName(Input.getString("\033[33m" + "Spieler vier geben Sie Ihren Namen ein: " + "\033[0m"));
        }
        Output.map(fieldArray);
        while (true)
        {
//        Play one round
            playOneMove(fieldArray, playerOne, allPlayers);
            Output.map(fieldArray);
            if (playerAmount >= 2)
            {
                playOneMove(fieldArray, playerTwo, allPlayers);
                Output.map(fieldArray);
            }
            if (playerAmount >= 3)
            {
                playOneMove(fieldArray, playerThree, allPlayers);
                Output.map(fieldArray);
            }
            if (playerAmount == 4)
            {
                playOneMove(fieldArray, playerFour, allPlayers);
                Output.map(fieldArray);
            }

        }
    }

    /**
     * Diese Methode durchläuft einen Spielzug, sie lässt den Benutzer würfeln und eine Figur auswählen, um diese zu bewegen.
     *
     * @param fieldArray {@link Field Array} mit allen {@link Field Feldern}.
     * @param player     Der {@link Player Spieler} der den Zug {@link Figure Figur} tätigt.
     * @param allPlayers Ein {@link Player[] Spieler[]} Array mit allen {@link Player Spieler}.
     *
     * @author EGA
     */
    private static void playOneMove(Field[] fieldArray, Player player, Player[] allPlayers)
    {
//        Die Zahl würfeln
        System.out.println(player.getName() + " Würfeln sie mit enter: ");
        int diceNumber = Dice.roll();
        System.out.println(player.getName() + " hat: " + diceNumber + " gewürfelt!");
        if (isEveryFigureInsideHouse(player) && diceNumber != 6)
        {
            System.out.println(player.getName() + " Würfeln sie mit enter: ");
            diceNumber = Dice.roll();
            System.out.println(player.getName() + " hat: " + diceNumber + " gewürfelt!");
            if (diceNumber != 6)
            {
                System.out.println(player.getName() + " Würfeln sie mit enter: ");
                diceNumber = Dice.roll();
                System.out.println(player.getName() + " hat: " + diceNumber + " gewürfelt!");
            }
            if (diceNumber != 6)
            {
                return;
            }
        }
//       Die Figur zum Bewegen auswählen
        boolean blockedByMate = true;
        while (blockedByMate)
        {
            int chosenFigure = Input.getInt("Welche Figur möchten Sie bewegen?: ") - 1;
            Figure figure = player.getFigureArray()[chosenFigure];
            int currentLocation = figure.getPosition();
            int[] path = player.getPath();
            Figure figureAtNewLocation = checkForNextFigure(fieldArray, diceNumber, figure, player);
            if (diceNumber == 6 && figure.isInsideHome())
            {
                Figure figureAtMySpawnLocation = fieldArray[path[4]].getFigure();
                if (figureAtMySpawnLocation != null)
                {
                    if (figureAtMySpawnLocation.getNumber() != figure.getNumber())
                    {
                        moveFigureBackInHouse(fieldArray, fieldArray[path[4]].getFigure());
                    }
                    else
                    {
                        System.out.println("Blocked by your mate!");
                        break;
                    }
                }
                moveFigureToThisIndex(fieldArray, figure, 4, path);
                figure.setInsideHome(false);
                break;
            }
//        Kontrollieren, ob das Feld frei ist
            else if (figureAtNewLocation != null && !figure.isInsideHome()) // Gehe ins if, wenn das Feld blockiert ist.
            {
                int whatPlayerIsThat = figureAtNewLocation.getNumber();
                if (whatPlayerIsThat != figure.getNumber())
                {
                    moveFigureBackInHouse(fieldArray, figureAtNewLocation);
                    blockedByMate = false;
                }
                else
                {
                    System.out.println("That is your mate bruh");
                    break;
                }
            }
//            Bewege die ausgewählte Figure in das Feld
            if (!figure.isInsideHome())
            {
                int pathIndexOfNewPosition = getIndexFromPath(path, currentLocation) + diceNumber; // Das ist der Index vom Weg an der neuen Stelle zu der sich die Figur bewegt
                moveFigureToThisIndex(fieldArray, figure, pathIndexOfNewPosition, path);
                break;
            }
            if (figure.isInsideHome())
            {
                System.out.println("Skip");
                blockedByMate = false;
            }
        }
        int winner = didSomeoneWin(allPlayers);
        if (winner != -1)
        {
            Output.map(fieldArray);
            System.out.println("\n" +
                    " .---.  .---.         .--.      .--..-./`) ,---.   .--.,---.   .--.    .-''-.  .-------.             .---.  .---.  \n" +
                    " \\   /  \\   /         |  |_     |  |\\ .-.')|    \\  |  ||    \\  |  |  .'_ _   \\ |  _ _   \\            \\   /  \\   /  \n" +
                    " |   |  |   |         | _( )_   |  |/ `-' \\|  ,  \\ |  ||  ,  \\ |  | / ( ` )   '| ( ' )  |            |   |  |   |  \n" +
                    "  \\ /    \\ /          |(_ o _)  |  | `-'`\"`|  |\\_ \\|  ||  |\\_ \\|  |. (_ o _)  ||(_ o _) /             \\ /    \\ /   \n" +
                    "   v      v           | (_,_) \\ |  | .---. |  _( )_\\  ||  _( )_\\  ||  (_,_)___|| (_,_).' __            v      v    \n" +
                    "  _ _    _ _          |  |/    \\|  | |   | | (_ o _)  || (_ o _)  |'  \\   .---.|  |\\ \\  |  |          _ _    _ _   \n" +
                    " (_I_)  (_I_)         |  '  /\\  `  | |   | |  (_,_)\\  ||  (_,_)\\  | \\  `-'    /|  | \\ `'   /         (_I_)  (_I_)  \n" +
                    "(_(=)_)(_(=)_)        |    /  \\    | |   | |  |    |  ||  |    |  |  \\       / |  |  \\    /         (_(=)_)(_(=)_) \n" +
                    " (_I_)  (_I_)         `---'    `---` '---' '--'    '--''--'    '--'   `'-..-'  ''-'   `'-'           (_I_)  (_I_)  \n" +
                    "                                                                                                                   \n");
            System.out.println("Spieler: " + winner + " " + allPlayers[winner - 1].getName() + " hat gewonnen!");
            throw new ConcurrentModificationException();
        }
    }

    /**
     * Diese Methode prüft, ob ein {@link Player Spieler} gewonnen hat.
     *
     * @param allPlayers Ein {@link Player[] Spieler[]} Array mit allen {@link Player Spieler}.
     *
     * @return Die {@link int Nummer} vom {@link Player Spieler} der gewonnen hat, falls keiner gewonnen hat -1.
     *
     * @author EGA
     */
    private static int didSomeoneWin(Player[] allPlayers)
    {

        for (int i = 0; i < 4; i++)
        {
            int counter = 0;
            for (int j = 0; j < 4; j++)
            {
                if (allPlayers[i].getFigureArray()[j].isInsideGoal())
                {
                    counter++;
                }
                if (counter == 4)
                {
                    return i + 1; // Wer gewonnen hat (Spieler Nummer)
                }
            }
        }
        return -1; // Wenn niemand gewonnen hat
    }

    /**
     * Diese Methode bewegt eine {@link Figure Figur} zu dem gewünschten {@link int index} vom {@link int[] Path}.<br>
     * Es erfolgt eine Prüfung, ob die {@link Figure Figur} sich überhaupt an die gewünschte Stelle bewegen kann
     * und wenn die Stelle im Ziel angekommen ist, wird der {@link Boolean boolean} für diese {@link Figure Figur} geändert.
     *
     * @param fieldArray {@link Field Array} mit allen {@link Field Feldern}.
     * @param figure     Die {@link Figure Figur} die bewegt werden soll.
     * @param index      Die {@link int Stelle} an die sich bewegt werden soll.
     * @param path       {@link int[] Path}
     *
     * @author EGA
     */
    private static void moveFigureToThisIndex(Field[] fieldArray, Figure figure, int index, int[] path)
    {
        if (index > 47)
        {
            System.out.println("Index out of Bounds verhindert!");
            return;
        }
        int currentPosition = figure.getPosition();
        fieldArray[currentPosition].setFigure(null);
        fieldArray[path[index]].setFigure(figure);
        figure.setPosition(path[index]);
        if (index > 43)
        {
            figure.setInsideGoal(true);
        }
    }

    /**
     * Diese Methode bewegt eine {@link Figure Figur} zurück in ihr Haus.
     *
     * @param fieldArray {@link Field Array} mit allen {@link Field Feldern}.
     * @param figure     Die {@link Figure Figur} die zurückbewegt werden soll.
     *
     * @author EGA
     */
    private static void moveFigureBackInHouse(Field[] fieldArray, Figure figure)
    {
        int currentPosition = figure.getPosition();
        fieldArray[currentPosition].setFigure(null);
        fieldArray[figure.getMyHousePosition()].setFigure(figure);
        figure.setPosition(figure.getMyHousePosition());
        figure.setInsideHome(true);
    }

    /**
     * Diese Methode prüft, welche {@link Figure Figur} an der nächsten Stelle ist.
     *
     * @param fieldArray {@link Field Array} mit allen {@link Field Feldern}.
     * @param diceNumber {@link int Zahl} die gewürfelt wurde.
     * @param figure     Die {@link Figure Figur} die bewegt/geprüft werden soll.
     * @param player     Der {@link Player Spieler} dem die {@link Figure Figur} gehört.
     *
     * @return Die {@link Figure Figur} an der nächsten Stellen oder {@link null}
     *
     * @author EGA
     */
    private static Figure checkForNextFigure(Field[] fieldArray, int diceNumber, Figure figure, Player player)
    {
        int[] path = player.getPath();
        int indexLocation = getIndexFromPath(path, figure.getPosition());
        if (indexLocation + diceNumber > 47)
        {
            System.out.println("Nächste Figur ist out of bounce!");
            return null;
        }
        Figure figureAtNewLocation = fieldArray[path[indexLocation + diceNumber]].getFigure();
        if (figureAtNewLocation == null)
        {
            return null;
        }
        else
        {
            return figureAtNewLocation;
        }
    }

    /**
     * Diese Methode liefert dir den Index von der derzeitigen Position im Path Array.
     * BSP.
     * path -> 5,6,7,8,23,24,25,26,27
     * position -> 8
     * Index -> 3
     *
     * @param path                {@link int Zahlen array} in dem der Weg gespeichert ist.
     * @param currentPathLocation {@link int Zahl} der derzeitigen Postion im path.
     *
     * @return Index vom {@link int[] path}.
     *
     * @author EGA
     */
    private static int getIndexFromPath(int[] path, int currentPathLocation)
    {
        int index = -1;
        for (int i = 0; i < path.length; i++)
        {
            if (path[i] == currentPathLocation)
            {
                index = i;
                break;
            }
        }
        return index;
    }

    /**
     * Diese Methode legt die Anfangspositionen fest, an denen die {@link Figure Figuren} starten und wo deren Haus ist.
     *
     * @param fieldArray {@link Field Array} mit allen Feldern, um die Positionen richtig auf diese zu setzen.
     * @param figures    {@link Figure Array} mit allen {@link Figure Figuren}
     * @param i          Position von der ersten {@link Figure Figur}
     * @param i1         Position von der zweiten {@link Figure Figur}
     * @param i2         Position von der dritten {@link Figure Figur}
     * @param i3         Position von der vierten {@link Figure Figur}
     *
     * @author EGA
     */
    private static void setPositions(Field[] fieldArray, Figure[] figures, int i, int i1, int i2, int i3)
    {
        figures[0].setPosition(i);
        figures[0].setMyHousePosition(i);
        figures[1].setPosition(i1);
        figures[1].setMyHousePosition(i1);
        figures[2].setPosition(i2);
        figures[2].setMyHousePosition(i2);
        figures[3].setPosition(i3);
        figures[3].setMyHousePosition(i3);

        fieldArray[i].setFigure(figures[0]);
        fieldArray[i1].setFigure(figures[1]);
        fieldArray[i2].setFigure(figures[2]);
        fieldArray[i3].setFigure(figures[3]);
    }

    /**
     * Erstellt ein Array mit 4 {@link Figure Figuren}.
     *
     * @param playerNumber Die {@link int Zahl} zu welchem {@link Player Spieler} die {@link Figure Figuren} gehören.
     * @param operator     Das Zeichen als Symbol für die Figuren.
     * @param color        Die Farbe der {@link Figure Figuren}.
     *
     * @return Ein Array mit 4 {@link Figure Figuren}
     *
     * @author EGA
     */
    private static Figure[] createFigureArray(int playerNumber, String operator, String color)
    {
        String reset = "\033[0m";
        Figure[] figures = new Figure[4];
        for (int i = 0; i < 4; i++)
        {
            figures[i] = new Figure(color + (i + 1) + operator + reset, playerNumber);
        }
        return figures;
    }

    /**
     * Diese Methode prüft, ob alle Figuren im Haus sind.
     *
     * @param player vom wem sollen die Figuren überprüft werden..
     *
     * @return {@link boolean true} wenn alle Figuren im Haus sind.
     *
     * @author EGA
     */
    private static boolean isEveryFigureInsideHouse(Player player)
    {
        int counter = 0;
        for (int i = 0; i < 4; i++)
        {
            if (player.getFigureArray()[i].isInsideHome())
            {
                counter++;
            }
        }
        return counter == 4; // Wenn alle im House = true, ansonsten false
    }
}
