package MiniGames.Hangman;

public class Player
{
    private int wrongGuesses;
    private String name;
    private String wordToGuess;
    private char[] wrongLetters = new char[12];
    private String[] wrongWords = new String[12];

    public void addLetter(char letter){
        for (int i = 0; i < wrongLetters.length; i++)
        {
            if (wrongLetters[i] == 0)
            {
                wrongLetters[i] = letter;
                return;
            }
        }
    }

    public void addWord(String word){
        for (int i = 0; i < word.length(); i++)
        {
            if (wrongWords[i] == null)
            {
                wrongWords[i] = word;
                return;
            }
        }
    }
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
        return wrongGuesses;
    }

    public Player setWrongGuesses(int wrongGuesses)
    {
        this.wrongGuesses = wrongGuesses;
        return this;
    }

    public void increaseWrongGuesses()
    {
        setWrongGuesses(getWrongGuesses()+1);
    }

    public char[] getWrongLetters()
    {
        return wrongLetters;
    }

    public Player setWrongLetters(char[] wrongLetters)
    {
        this.wrongLetters = wrongLetters;
        return this;
    }

    public String[] getWrongWords()
    {
        return wrongWords;
    }

    public Player setWrongWords(String[] wrongWords)
    {
        this.wrongWords = wrongWords;
        return this;
    }
}
