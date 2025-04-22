package MiniGames.Dont_Get_Angry.Logic;

import MiniGames.Dont_Get_Angry.Board.Field;
import MiniGames.Dont_Get_Angry.Board.Figure;
import MiniGames.Dont_Get_Angry.Console.Input;
import MiniGames.Dont_Get_Angry.Console.Output;
import MiniGames.Dont_Get_Angry.Factory.FieldFactory;
import MiniGames.Dont_Get_Angry.Inspector.Inspector;
import MiniGames.Dont_Get_Angry.Player;

public class Game
{
    public static void start()
    {
//        Initialize Board
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
        int[] p2Path = new int[]{4, 5, 6, 7, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 60, 61 ,62 ,63
        };
        int[] p3Path = new int[]{8, 9, 10, 11, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 68, 69, 70, 71
        };
        int[] p4Path = new int[]{12, 13, 14, 15, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35
        };
//        Asking for Player Number
        int playerAmount = Input.getInt("Wie viele Spieler sind da: ");
//        Create first two players
        Player playerOne = new Player(Input.getString("Spieler eins geben Sie Ihren Namen ein: "), figuresPTwo, 2,p1Path);
        Player playerTwo = new Player("", figuresPTwo, 2,p2Path);
//        Create optional players
        Player playerThree = new Player("", figuresPThree, 3,p3Path);
        Player playerFour = new Player("", figuresPFour, 4,p4Path);
        playerOne.setSpawnField(16);
        playerTwo.setSpawnField(26);
        playerThree.setSpawnField(46);
        playerFour.setSpawnField(36);
        if (playerAmount >= 2)
        {
            playerTwo.setName(Input.getString("Spieler zwei geben Sie Ihren Namen ein: "));

        }
        if (playerAmount >= 3)
        {
            playerThree.setName(Input.getString("Spieler drei geben Sie Ihren Namen ein: "));
        }
        if (playerAmount == 4)
        {
            playerFour.setName(Input.getString("Spieler vier geben Sie Ihren Namen ein: "));
        }
        Output.map(fieldArray);
        while (true)
        {
//        Spiele ein Runde
            playOneRound(fieldArray, playerOne);
            Output.map(fieldArray);
            if (playerAmount >= 2)
            {
                playOneRound(fieldArray, playerTwo);
                Output.map(fieldArray);
            }
            if (playerAmount >= 3)
            {
                playOneRound(fieldArray, playerThree);
                Output.map(fieldArray);
            }
            if (playerAmount == 4)
            {
                playOneRound(fieldArray, playerFour);
                Output.map(fieldArray);
            }

        }
    }

    private static void newMovementTech(Field[] fieldArray, Player player){
        System.out.println(player.getName() + " Würfeln sie mit enter: ");
        int diceNumber = Dice.roll();
        System.out.println(player.getName() + " hat: " + diceNumber + " gewürfelt!");
        Figure figureBlockingMe;
        int chosenFigure = Input.getInt("Welche Figur möchten Sie bewegen?: ");
        int currentPosition = player.getFigureArray()[chosenFigure - 1].getPosition();
//        Arbeite mit dem Array als Path index addieren zum moven und dann prüfen ob diese Zahl besetzt ist und von wem,
//        um den später zurück zu schicken
    }

    private static void setPositions(Field[] fields, Figure[] figures, int i, int i1, int i2, int i3)
    {
        figures[0].setPosition(i);
        figures[1].setPosition(i1);
        figures[2].setPosition(i2);
        figures[3].setPosition(i3);

        fields[i].setFigure(figures[0]);
        fields[i1].setFigure(figures[1]);
        fields[i2].setFigure(figures[2]);
        fields[i3].setFigure(figures[3]);
    }

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

    private static void playOneRound(Field[] fieldArray, Player player)
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println(player.getName() + " Würfeln sie mit enter: ");
            int number = Dice.roll();
            System.out.println(player.getName() + " hat: " + number + " gewürfelt!");
            if (number == 6)
            {
                if (Inspector.allFiguresInSpawn(fieldArray, player) && fieldArray[player.getSpawnField()].getFigure() == null)
                {
                    moveFigureOutOfSpawn(fieldArray, player, Input.getInt("Welche Figur möchten Sie aus dem Spawn bewegen?"));
                }
                else
                {
                    int chosenFigure = Input.getInt("Welche Figur möchten Sie bewegen?");
                    if (player.getFigureArray()[chosenFigure - 1].isInsideHome() && fieldArray[player.getSpawnField()].getFigure() == null)
                    {
                        moveFigureOutOfSpawn(fieldArray, player, chosenFigure);
                    }
                    else
                    {
                        moveFigure(fieldArray, player, chosenFigure, number);
                    }
                }
                break;
            }
            if (!Inspector.allFiguresInSpawn(fieldArray, player))
            {
                moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), number);
                break;
            }
        }
    }

    // Walking on sunshine = iCarly intro
    private static void moveFigure(Field[] fieldArray, Player player, int chosenFigure, int diceNumber)
    {
        Figure figure = player.getFigureArray()[chosenFigure - 1];
        int currentPosition = figure.getPosition();
        if (figure.isInsideHome() && fieldArray[player.getSpawnField()].getFigure() == null)
        {
            if (diceNumber == 6)
            {
                moveFigureOutOfSpawn(fieldArray, player, chosenFigure);
            }
            else
            {
                System.out.println("Sie können diese Figur nicht bewegen!");
                moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), diceNumber);
            }
        }
        else
        {
            if (fieldArray[currentPosition + diceNumber].getFigure() == null)
            {
                switch (player.getPlayerNumber())
                {
                    case 1:
                        if (currentPosition + diceNumber > 59)
                        {
                            System.out.println("Diese Bewegung ist unzulässig.");
                            moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), diceNumber);
                            break;
                        }
                        figure.setPosition(currentPosition + diceNumber);
                        fieldArray[currentPosition + diceNumber].setFigure(figure);
                        fieldArray[currentPosition].setFigure(null);
                        break;
                    case 2:
                        if (currentPosition + diceNumber > 63)
                        {
                            System.out.println("Diese Bewegung ist unzulässig.");
                            moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), diceNumber);
                            break;
                        }
                        else if (currentPosition > 19 && currentPosition < 26)
                        {
                            if (currentPosition + diceNumber > 25)
                            {
                                figure.setPosition(currentPosition + diceNumber + 34);
                                fieldArray[currentPosition + diceNumber + 34].setFigure(figure);
                                fieldArray[currentPosition].setFigure(null);
                            }
                            else
                            {
                                goAroundRed(fieldArray, diceNumber, currentPosition, figure);
                                break;
                            }
                        }
                        else
                        {
                            goAroundRed(fieldArray, diceNumber, currentPosition, figure);
                            break;
                        }
                        break;
                    case 3:
                        if (currentPosition + diceNumber > 67)
                        {
                            System.out.println("Diese Bewegung ist unzulässig.");
                            moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), diceNumber);
                            break;
                        }
                        else if (currentPosition > 39 && currentPosition < 46)
                        {
                            if (currentPosition + diceNumber > 45)
                            {
                                figure.setPosition(currentPosition + diceNumber + 22);
                                fieldArray[currentPosition + diceNumber + 22].setFigure(figure);
                                fieldArray[currentPosition].setFigure(null);

//                                System.out.println("Diese Bewegung ist unzulässig.");
//                                moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), diceNumber);
//                                break;
                            }
                        }
                        else
                        {
                            goAroundRed(fieldArray, diceNumber, currentPosition, figure);
                            break;
                        }
                    case 4:
                        if (currentPosition + diceNumber > 71)
                        {
                            System.out.println("Diese Bewegung ist unzulässig.");
                            moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), diceNumber);
                            break;
                        }
                        else if (currentPosition > 29 && currentPosition < 36)
                        {
                            if (currentPosition + diceNumber > 35)
                            {
                                figure.setPosition(currentPosition + diceNumber + 28);
                                fieldArray[currentPosition + diceNumber + 28].setFigure(figure);
                                fieldArray[currentPosition].setFigure(null);

//                                System.out.println("Diese Bewegung ist unzulässig.");
//                                moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), diceNumber);
//                                break;
                            }
                        }
                        else
                        {
                            goAroundRed(fieldArray, diceNumber, currentPosition, figure);
                            break;
                        }
                }
            }
            else
            {
                System.out.println("Dies ist leider nicht möglich");
                moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), diceNumber);
            }
        }
    }

    private static void goAroundRed(Field[] fieldArray, int diceNumber, int currentPosition, Figure figure)
    {
        if (currentPosition + diceNumber > 55 && currentPosition + diceNumber <= 60)
        {
            figure.setPosition(currentPosition + diceNumber - 40);
            fieldArray[currentPosition + diceNumber - 40].setFigure(figure);
            fieldArray[currentPosition].setFigure(null);
        }
        else
        {
            figure.setPosition(currentPosition + diceNumber);
            fieldArray[currentPosition + diceNumber].setFigure(figure);
            fieldArray[currentPosition].setFigure(null);
        }
    }

    private static void moveFigureOutOfSpawn(Field[] fieldArray, Player player, int figureNumber)
    {
        if (player.getFigureArray()[figureNumber - 1].isInsideHome())
        {
            switch (player.getPlayerNumber())
            {
                case 1:
                    if (fieldArray[16].getFigure() != null)
                    {
                        System.out.println("Spawn ist belegt");
                        moveFigureOutOfSpawn(fieldArray, player, Input.getInt("Wählen Sie eine andere Figur!"));
                        return;
                    }
                case 2:
                    if (fieldArray[26].getFigure() != null)
                    {
                        System.out.println("Spawn ist belegt");
                        return;
                    }
                case 3:
                    if (fieldArray[46].getFigure() != null)
                    {
                        System.out.println("Spawn ist belegt");
                        return;

                    }
                case 4:
                    if (fieldArray[36].getFigure() != null)
                    {
                        System.out.println("Spawn ist belegt");
                        return;
                    }
            }
            Figure figure = player.getFigureArray()[figureNumber - 1];
            figure.setInsideHome(false);
            int currentPosition = figure.getPosition();
            fieldArray[currentPosition].setFigure(null);
            switch (player.getPlayerNumber())
            {
                case 1:
                    figure.setPosition(16);
                    fieldArray[16].setFigure(figure);
                    break;
                case 2:
                    figure.setPosition(26);
                    fieldArray[26].setFigure(figure);
                    break;
                case 3:
                    figure.setPosition(46);
                    fieldArray[46].setFigure(figure);
                    break;
                case 4:
                    figure.setPosition(36);
                    fieldArray[36].setFigure(figure);
                    break;
            }
        }
    }
}
