package MiniGames.Connect_Four;

public class Checker
{
    public static boolean winnersCheck(String[][] fieldPosition, Player player)
    {
//        Check for left and right
        int counter = 0;
        for (int i = 0; i < fieldPosition.length; i++)
        {
            for (int j = 0; j < 7; j++)
            {
                if (fieldPosition[i][j] != null && fieldPosition[i][j].equals(player.getOperator()))
                {
                    counter++;
                }
                else
                {
                    counter = 0;
                }
                if (counter == 4)
                {
                    return true;
                }
            }
            counter = 0;
        }
//        Check for up and down
        for (int i = 0; i < fieldPosition.length + 1; i++)
        {
            for (int j = 0; j < fieldPosition.length; j++)
            {
                if (j >=7 || i >= 7){
                    continue;
                }
                if (fieldPosition[j][i] != null && fieldPosition[j][i].equals(player.getOperator()))
                {
                    counter++;
                }
                else
                {
                    counter = 0;
                }
                if (counter == 4)
                {
                    return true;
                }
            }
        }
        // Check for Diagonal (left-top to right-bottom) eh
        for (int i = 0; i < fieldPosition.length - 3; i++) {
            for (int j = 0; j < 7 - 3; j++) {
                counter = 0;
                for (int k = 0; k < 4; k++) {
                    if (fieldPosition[i + k][j + k] != null && fieldPosition[i + k][j + k].equals(player.getOperator())) {
                        counter++;
                    } else {
                        break;
                    }
                }
                if (counter == 4) {
                    return true;
                }
            }
        }

        // Check for Diagonal (right-top to left-bottom)
        for (int i = 0; i < fieldPosition.length - 3; i++) {
            for (int j = 3; j < 7; j++) {
                counter = 0;
                for (int k = 0; k < 4; k++) {
                    if (fieldPosition[i + k][j - k] != null && fieldPosition[i + k][j - k].equals(player.getOperator())) {
                        counter++;
                    } else {
                        break;
                    }
                }
                if (counter == 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String[][] gravityCheck(String[][] fieldPosition, Player player)
    {
        int playerAction = player.getAction() - 1;
        for (int i = 0; i < fieldPosition.length; i++)
        {
            if (fieldPosition[i][playerAction] == null)
            {
                fieldPosition[i][playerAction] = player.getOperator();
                if (i != 0)
                {
                    fieldPosition[i - 1][playerAction] = null;
                }
            }
            else
            {
                return fieldPosition;
            }
        }
        return fieldPosition;
    }
}

