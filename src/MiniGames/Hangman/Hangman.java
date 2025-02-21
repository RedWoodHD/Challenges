package MiniGames.Hangman;

import java.util.NoSuchElementException;

public class Hangman
{
    private static final Player playerOne = new Player();
    private static final Player playerTwo = new Player();
    private static boolean isGameRunning = true;
    public static void start()
    {
            playerOne.setName(UserInput.readString("Spieler eins geben Sie Ihren Namen an: "));
            playerTwo.setName(UserInput.readString("Spieler zwei geben Sie Ihren Namen an: "));
            playerOne.setWordToGuess(UserInput.readNormalLetterText("Welches Wort soll ihr gegenüber erraten"));
            boolean hangmanDied = false;
            flush();
            WordOutPut wordOutPut = new WordOutPut();
            char[] rightGuesses = new char[playerOne.getWordToGuess().length()];
            WordOutPut.printBlankWord(playerOne.getWordToGuess());
            while (isGameRunning)
            {
                if (playerTwo.getWrongGuesses() > 11)
                {
                    isGameRunning = false;
                    hangmanDied = true;
                    continue;
                }
                if (wordOutPut.printWordBox(playerOne.getWordToGuess(), makeAnGuess(playerOne, playerTwo), rightGuesses))
                {
                    break;
                }
            }
            if (hangmanDied)
            {
                System.out.println("┌─┐┌─┐┌┬┐┌─┐  ┌─┐┬  ┬┌─┐┬─┐\n" +
                        "│ ┬├─┤│││├┤   │ │└┐┌┘├┤ ├┬┘\n" +
                        "└─┘┴ ┴┴ ┴└─┘  └─┘ └┘ └─┘┴└─");
            }
            else
            {
                System.out.println(playerTwo.getName() + " you won the game!");
                System.out.println("""
                                                                                      /$$               /$$             /$$     /$$                             \s
                                                                                     | $$              | $$            | $$    |__/                             \s
                          /$$$$$$$  /$$$$$$  /$$$$$$$   /$$$$$$   /$$$$$$  /$$$$$$  /$$$$$$   /$$   /$$| $$  /$$$$$$  /$$$$$$   /$$  /$$$$$$  /$$$$$$$   /$$$$$$$
                         /$$_____/ /$$__  $$| $$__  $$ /$$__  $$ /$$__  $$|____  $$|_  $$_/  | $$  | $$| $$ |____  $$|_  $$_/  | $$ /$$__  $$| $$__  $$ /$$_____/
                        | $$      | $$  \\ $$| $$  \\ $$| $$  \\ $$| $$  \\__/ /$$$$$$$  | $$    | $$  | $$| $$  /$$$$$$$  | $$    | $$| $$  \\ $$| $$  \\ $$|  $$$$$$\s
                        | $$      | $$  | $$| $$  | $$| $$  | $$| $$      /$$__  $$  | $$ /$$| $$  | $$| $$ /$$__  $$  | $$ /$$| $$| $$  | $$| $$  | $$ \\____  $$
                        |  $$$$$$$|  $$$$$$/| $$  | $$|  $$$$$$$| $$     |  $$$$$$$  |  $$$$/|  $$$$$$/| $$|  $$$$$$$  |  $$$$/| $$|  $$$$$$/| $$  | $$ /$$$$$$$/
                         \\_______/ \\______/ |__/  |__/ \\____  $$|__/      \\_______/   \\___/   \\______/ |__/ \\_______/   \\___/  |__/ \\______/ |__/  |__/|_______/\s
                                                       /$$  \\ $$                                                                                                \s
                                                      |  $$$$$$/                                                                                                \s
                                                       \\______/                                                                                                 \s
                        """);
            }
    }

    private static char[] makeAnGuess(Player playerOne, Player playerTwo)
    {
        String word = playerOne.getWordToGuess();
        String userInput = UserInput.readString(playerOne.getName() +" fangen Sie an zu raten: ");
        char[] userGuess;
        userGuess = userInput.toCharArray();
        if (checkForGuess(word,userInput))
        {
            return userGuess;
        } else
        {
            playerTwo.increaseWrongGuesses();
            flush();
            PictureOfHangman.printStage(playerTwo.getWrongGuesses());
            return userGuess;
        }
    }

    private static boolean checkForGuess(String word, String userInput)
    {
        int j = 1;
        for (int i = 0; i < word.length(); i++)
        {
            if (word.substring(i,j).equalsIgnoreCase(userInput)){
                return true;
            }
            j++;
        }
        return word.equalsIgnoreCase(userInput);
    }

    private static void flush()
    {
        for (int i = 0; i < 1000; i++)
        {
            System.out.println();
        }
    }
}
