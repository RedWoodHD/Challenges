package MiniGames.Dont_Get_Angry.Inspector;

import MiniGames.Dont_Get_Angry.Board.Field;
import MiniGames.Dont_Get_Angry.Board.Figure;
import MiniGames.Dont_Get_Angry.Player;

import java.util.regex.Pattern;

public class Inspector
{
    public static boolean spawn(Field[] allFields, Player player)
    {
        // Nehme die Operatoren als Ganzes ohne das substring() (Escape-Sequenzen werden jetzt entfernt)
        String operatorOne = removeEscapeSequences(player.getFigureArray()[0].getOperator());   // Ganzes "1▲"
        String operatorTwo = removeEscapeSequences(player.getFigureArray()[1].getOperator());   // Ganzes "2▲"
        String operatorThree = removeEscapeSequences(player.getFigureArray()[2].getOperator()); // Ganzes "3▲"
        String operatorFour = removeEscapeSequences(player.getFigureArray()[3].getOperator()); // Ganzes "4▲"

        // Erstelle den Regex für diese Operatoren
        String regex = "(" + Pattern.quote(operatorOne) + "|" +
                Pattern.quote(operatorTwo) + "|" +
                Pattern.quote(operatorThree) + "|" +
                Pattern.quote(operatorFour) + ")";
        Pattern pattern = Pattern.compile(regex);

        // Überprüfe je nach Playernummer
        switch (player.getPlayerNumber())
        {
            case 1:
                // Überprüfe den regulären Ausdruck für die entsprechenden Felder
//                if (removeEscapeSequences(allFields[0].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[1].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[7].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[8].getOperator()).matches(regex))
            {
                return true;
            }
//                break; // Verhindert das Durchfallen zu den nächsten Cases

            case 2:
                // Gleiche Überprüfung für Player 2
//                if (removeEscapeSequences(allFields[5].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[6].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[12].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[13].getOperator()).matches(regex))
            {
                return true;
            }
//                break;

            case 3:
                // Gleiche Überprüfung für Player 3
//                if (removeEscapeSequences(allFields[58].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[59].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[65].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[66].getOperator()).matches(regex))
            {
                return true;
            }
//                break;

            case 4:
                // Gleiche Überprüfung für Player 4
//                if (removeEscapeSequences(allFields[63].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[64].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[70].getOperator()).matches(regex) &&
//                        removeEscapeSequences(allFields[71].getOperator()).matches(regex))
            {
                return true;
            }
//                break;
        }
        return false;
    }

    public static boolean figureInSpawn(Field[] allFields,Figure figure)
    {
        for (int i = 0; i < 16; i++)
        {
            if (allFields[i].getFigure() != null)
            {
                if (allFields[i].getFigure().equals(figure)){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean allFiguresInSpawn(Field[] allFields, Player player)
    {
        switch (player.getPlayerNumber())
        {
            case 1:
                for (int i = 0; i < 4; i++)
                {
                    if (allFields[i].getFigure() == null)
                    {
                        return false;
                    }
                }
                return true;
            case 2:
                for (int i = 4; i < 8; i++)
                {
                    if (allFields[i].getFigure() == null)
                    {
                        return false;
                    }
                }
                return true;
            case 3:
                for (int i = 8; i < 12; i++)
                {
                    if (allFields[i].getFigure() == null)
                    {
                        return false;
                    }
                }
                return true;
            case 4:
                for (int i = 12; i < 16; i++)
                {
                    if (allFields[i].getFigure() == null)
                    {
                        return false;
                    }
                }
                return true;
        }
        return true;
    }

    public static String removeEscapeSequences(String input)
    {
        // Entfernt alle ANSI Escape-Sequenzen (z.B. \033[31m für Farben)
        return input.replaceAll("\033\\[[;\\d]*m", "");
    }
}
