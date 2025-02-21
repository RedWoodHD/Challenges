package MiniGames.Hangman;

public class WordOutPut
{
    private static boolean skip = false;

    public static void printBlankWord(String word)
    {
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            System.out.print("───");
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            printTop();
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            printMiddle(' ');
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            printBottom();
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            System.out.print("───");
        }
        System.out.println();
    }

    static boolean printWordBox(String word, char[] userGuess, char[] rightGuesses)
    {
        char[] letters = word.toCharArray();
        int correctLetters = 0;
        for (int i = 0; i < word.length(); i++)
        {
            if (userGuess[i] == Character.toUpperCase(letters[i]) || userGuess[i] == Character.toLowerCase(letters[i])){
                correctLetters++;
            }
        }
        if (correctLetters == word.length()){
            for (int i = 0; i < word.length(); i++)
            {
                if (userGuess[i] == Character.toLowerCase(letters[i]) || userGuess[i] == Character.toUpperCase(letters[i]))
                {
                    rightGuesses[i] = userGuess[i];
                }
            }
        }
        for (int i = 0; i < word.length(); i++)
        {
            if (userGuess[0] == Character.toLowerCase(letters[i]) || userGuess[0] == Character.toUpperCase(letters[i]))
            {
                rightGuesses[i] = userGuess[0];
            }
        }

        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            System.out.print("───");
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            printTop();
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            for (int j = 0; j < rightGuesses.length; j++)
            {
                if (letters[i] == Character.toLowerCase(rightGuesses[j]) || letters[i] == Character.toUpperCase(rightGuesses[j]) )
                {
                    printMiddle(letters[i]);
                    skip = true;
                    break;
                }
            }
            if (!skip)
            {
                printMiddle(' ');
            }
            skip = false;
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            printBottom();
        }
        System.out.println();
        for (int i = 0; i < word.length(); i++)
        {
            System.out.print("───");
        }
        System.out.println();
        if (String.valueOf(letters).equalsIgnoreCase(String.valueOf(rightGuesses)))
        {
            return true;
        }
        return false;
    }

    private static void printTop()
    {
        // ┼,┬,┴,├,┤,═,║,┌,┐,└,┘,─,│,
        System.out.print("┌─┐");

    }

    private static void printMiddle(char eh)
    {
        System.out.print("│" + eh + "│");

    }

    private static void printBottom()
    {
        System.out.print("└─┘");
    }

}
