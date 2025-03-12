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
        Figure[] figuresPOne = createFigureArray(1, "▲");
        Figure[] figuresPTwo = createFigureArray(2, "■");
        Figure[] figuresPThree = createFigureArray(3, "●");
        Figure[] figuresPFour = createFigureArray(4, "♦");
//        Set Spawn Figures
        setPositions(fieldArray, figuresPOne, 0, 1, 2, 3);
        setPositions(fieldArray, figuresPTwo, 4, 5, 6, 7);
        setPositions(fieldArray, figuresPThree, 8, 9, 10, 11);
        setPositions(fieldArray, figuresPFour, 12, 13, 14, 15);
//        Asking for Player Number
        int playerAmount = Input.getInt("Wie viele Spieler sind da: ");
//        Create first two players
        Player playerOne = new Player(Input.getString("Spieler eins geben Sie Ihren Namen ein: "), figuresPOne, 1);
        Player playerTwo = new Player("", figuresPTwo, 2);
//        Create optional players
        Player playerThree = new Player("", figuresPThree, 3);
        Player playerFour = new Player("", figuresPFour, 4);
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

    private static Figure[] createFigureArray(int playerNumber, String operator)
    {
        Figure[] figures = new Figure[4];
        for (int i = 0; i < 4; i++)
        {
            figures[i] = new Figure(i + 1 + operator, playerNumber);
        }
        return figures;
    }

    private static void playOneRound(Field[] fieldArray, Player player)
    {
        for (int i = 0; i < 3; i++)
        {
            System.out.println(player.getName() + " Würfeln sie mit enter: ");
            int number = Dice.roll();
            System.out.println(number);
            if (!Inspector.spawn(fieldArray, player))
            {
                break;
            }
            if (number == 6)
            {
                moveFigure(fieldArray, player, Input.getInt("Welche Figur möchten Sie bewegen?"), number);
                break;
            }
        }


    }

    private static void moveFigure(Field[] fieldArray, Player player, int chosenFigure, int diceNumber)
    {
        Figure figure = player.getFigureArray()[chosenFigure - 1];
        int currentPosition = figure.getPosition();
        if (Inspector.spawnCheck(fieldArray,player))
        {
            moveFigureOutOfSpawn(fieldArray,player,chosenFigure);
            return;
        }
        fieldArray[currentPosition].setFigure(null);
        fieldArray[currentPosition + diceNumber].setFigure(figure);
    }

    private static void moveFigureOutOfSpawn(Field[] fieldArray, Player player, int figureNumber)
    {
        Figure figure = player.getFigureArray()[figureNumber - 1];
        int currentPosition = figure.getPosition();
        fieldArray[currentPosition].setFigure(null);
        switch (player.getPlayerNumber())
        {
            case 1:
                fieldArray[16].setFigure(figure);
                break;
            case 2:
                fieldArray[26].setFigure(figure);
                break;
            case 3:
                fieldArray[46].setFigure(figure);
                break;
            case 4:
                fieldArray[36].setFigure(figure);
                break;
        }
    }
}
