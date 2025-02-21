package MiniGames.Hangman;

public class Player
{
    public int WrongGuesses;
    private String name;
    private String wordToGuess;

    public String getName()
    {
        return name;
    }

    public Player setName(String name)
    {
        this.name = name;
        return this;
    }

    public String getWordToGuess()
    {
        return wordToGuess;
    }

    public Player setWordToGuess(String wordToGuess)
    {
        this.wordToGuess = wordToGuess;
        return this;
    }

    public int getWrongGuesses()
    {
        return WrongGuesses;
    }

    public Player setWrongGuesses(int wrongGuesses)
    {
        WrongGuesses = wrongGuesses;
        return this;
    }

    public void increaseWrongGuesses()
    {
        setWrongGuesses(getWrongGuesses()+1);
    }
}
