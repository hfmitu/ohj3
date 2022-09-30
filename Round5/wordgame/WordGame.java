import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class WordGame {

    ArrayList<String> words;

    public static class WordGameState{
        String word;
        int mistakes;
        int maxmistakes;
        int unknown;

        String getWord(){
            return this.word;
        }

        int getMistakes(){
            return this.mistakes;
        }

        int getMistakeLimit(){
            return this.maxmistakes;
        }

        int getMissingChars(){
            return this.unknown;
        }
    }

    public WordGame(String name){
        try (BufferedReader br = new BufferedReader(new FileReader(name))) 
        {
            String currentLine;
            while ((currentLine = br.readLine()) != null) 
            {
                words.add(currentLine);
            }
        } 
        catch (IOException e) 
            {
                e.printStackTrace();
            }
    }

    public void initGame(int wordindex, int mistakelimit){
        WordGame.WordGameState game = new WordGameState();
        game.word=words.get(wordindex);
        game.maxmistakes=mistakelimit;
    }

}
