package MiniGames.Hangman;

public class Hangman
{
    private static final Player playerOne = new Player();
    private static final Player playerTwo = new Player();
    private static boolean isGameRunning = true;

    public static void start()
    {
        playerOne.setName(UserInput.readString("Spieler eins geben Sie Ihren Namen an: "));
        playerTwo.setName(UserInput.readString("Spieler zwei geben Sie Ihren Namen an: "));
        playerOne.setWordToGuess(UserInput.readNormalLetterText(playerOne.getName() + " welches Wort soll ihr gegenüber erraten"));
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
            if (wordOutPut.printWordBox(playerOne.getWordToGuess(), makeAnGuess(playerOne, playerTwo), rightGuesses,playerTwo))
            {
                break;
            }
        }
        if (hangmanDied)
        {
            System.out.println("Das Wort war: "+playerOne.getWordToGuess());
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
        String userInput = UserInput.readString(playerOne.getName() + " fangen Sie an zu raten: ");
        char[] userGuess;
        userGuess = userInput.toCharArray();
        if (checkForGuess(word, userInput,playerTwo))
        {
            return userGuess;
        }
        if (checkForDuplicateInput(userGuess,playerTwo, null)){
            System.out.println("Dieser Buchstabe ist immer noch falsch!!");
            return makeAnGuess(playerOne,playerTwo);
        }
        if (checkForDuplicateInput(userGuess,playerTwo, userInput)){
            System.out.println("Dieses Wort ist immer noch falsch!!");
            return makeAnGuess(playerOne,playerTwo);
        }
        else
        {
            playerTwo.increaseWrongGuesses();
            flush();
            PictureOfHangman.printStage(playerTwo.getWrongGuesses());
            if (userGuess.length == 1)
            {
                playerTwo.addLetter(userGuess[0]);
            }
            if (!userInput.equalsIgnoreCase(word)){
                playerTwo.addWord(userInput);
            }
            return null;
        }
    }

    private static boolean checkForDuplicateInput(char[] letterGuess, Player playerTwo, String wordGuess)
    {
        char[] wrongLetters = playerTwo.getWrongLetters();
        String[] wrongWords = playerTwo.getWrongWords();
        if (wordGuess != null){
            for (int i = 0; i <wrongWords.length ; i++)
            {
                if (wrongWords[i] != null)
                {
                    if (wrongWords[i].equalsIgnoreCase(wordGuess))
                    {
                        return true;
                    }
                }
            }
        }
        if (letterGuess.length != 1){
            return false;
        }
        for (int i = 0; i < wrongLetters.length; i++)
        {
            if (Character.toLowerCase(letterGuess[0]) == Character.toLowerCase(wrongLetters[i])){
                return true;
            }
        }
        return false;
    }

    private static boolean checkForGuess(String word, String userInput,Player playerTwo)
    {
        for (int i = 0; i < word.length(); i++)
        {
            if (userInput.equalsIgnoreCase(word))
            {
                return true;
            }
            if (Character.toLowerCase(word.charAt(i)) == Character.toLowerCase(userInput.charAt(0)) && userInput.length() == 1)
            {
                return true;
            }
        }
        if (!word.equalsIgnoreCase(userInput)){
            return false;
        }
        return true;
    }

    private static void flush()
    {
        for (int i = 0; i < 1000; i++)
        {
            System.out.println();
        }
    }
}
