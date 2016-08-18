package engine;

/**
 *  This class only stores information related to the word you are looking for,
 * they being the word itself, the page where the search is taking place and the
 * number of occurrences of the word on the page.
 * 
 * @author      Marcelo A. T. Gomes
 * 
 */
public class Target {
    
    /**
     * Stores the character set that you are looking for in the source folder.
     */
    private String word;
    
    /**
     * Stores the file path where the search is being conducted ..
     */
    private String filePath;
    
    /**
     * Count how many times the set of characters was found in the file where 
     * the search is being conducted.
     */
    private int occurrences;

    /**
     * @return the word
     */
    public String getWord() {
        return word;
    }

    /**
     * @param word the word to set
     */
    public void setWord(String word) {
        this.word = word;
    }

    /**
     * @return the filePath
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     * @param filePath the filePath to set
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * @return the occurrences
     */
    public int getOccurrences() {
        return occurrences;
    }

    /**
     * @param occurrences the occurrences to set
     */
    public void setOccurrences(int occurrences) {
        this.occurrences = occurrences;
    }
}
