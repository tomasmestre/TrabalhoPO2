package pt.ipbeja.app.model;


import java.util.ArrayList;
import java.util.List;

/**
 * Game model
 * @author Francisco Correia & Tomás Mestre
 * @version 2024/04/14
 */
public class WSModel {


    // The following matrix could also be List<List<Character>>
    // for a more complex game, it should be a List<List<Cell>>
    // where Letter is a class with the letter and other attributes
    private final List<List<String>> lettersGrid;
    private WSView wsView;

    public WSModel(ArrayList<String> words) {
        this.lettersGrid = new ArrayList<>();
        // Calculate the dimensions of the grid based on the longest word
        int maxLength = 0;
        for (String word : words) {
            maxLength = Math.max(maxLength, word.length());
        }
        int rows = words.size();
        int cols = maxLength;

        // Populate the lettersGrid with the words
        for (String word : words) {
            ArrayList<String> row = new ArrayList<>();
            for (int i = 0; i < cols; i++) {
                if (i < word.length()) {
                    row.add(word.charAt(i) + "");
                } else {
                    // If word is shorter than the maximum length, fill with random characters
                    row.add(generateRandomCharacter());
                }
            }
            lettersGrid.add(row);
        }
    }

    private String generateRandomCharacter() {
        // Generate a random uppercase letter
        return String.valueOf((char) ('A' + Math.random() * ('Z' - 'A' + 1)));
    }

    public int nLines() { return this.lettersGrid.size(); }
    public int nCols() { return this.lettersGrid.get(0).size(); }

    public void registerView(WSView wsView) {
        this.wsView = wsView;
    }

    /**
     * Get the text in a position
     * @param position  position
     * @return  the text in the position
     */
    public String textInPosition(Position position) {
        return this.lettersGrid.get(position.line()).get(position.col());
    }


    /**
     * Check if all words were found
     * @return  true if all words were found
     */
    public boolean allWordsWereFound() {
        // TODO: implement this method
        return true;
    }

    /**
     * Check if the word is in the board
     * @param word
     * @return true if the word is in the board
     */
    public String wordFound(String word) {
        // TODO implement this method
        return word;
    }

    /**
     * Check if the word with wildcard is in the board
     * @param word
     * @return  true if the word with wildcard is in the board
     */
    public String wordWithWildcardFound(String word) {
        // TODO implement this method
        return word;
    }
}
