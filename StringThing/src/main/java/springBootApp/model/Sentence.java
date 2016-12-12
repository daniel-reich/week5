
package springBootApp.model;


import java.lang.reflect.Array;
import java.util.ArrayList;

public class Sentence {
    private int words;
    private int characters;
    private String reverse;
    private String pigLatin;
    private ArrayList<String> searchWords;
    private String tableBuilder;

    public Sentence(int words, int characters, String reverse, String pigLatin, ArrayList<String> searchWords) {
        this.words = words;
        this.characters = characters;
        this.reverse = reverse;
        this.pigLatin = pigLatin;
        this.searchWords = searchWords;
    }

    public int getWords() {
        return words;
    }

    public int getCharacters() {
        return characters;
    }

    public String getReverse() {
        return reverse;
    }

    public String getPigLatin() {
        return pigLatin;
    }

    public ArrayList<String> getSearchWords() {
        return searchWords;
    }

    public String getTableBuilder() {
        return tableBuilder;
    }

    public void setWords(int words) {
        this.words = words;
    }

    public void setCharacters(int characters) {
        this.characters = characters;
    }

    public void setReverse(String reverse) {
        this.reverse = reverse;
    }

    public void setPigLatin(String pigLatin) {
        this.pigLatin = pigLatin;
    }

    public void setSearchWords(ArrayList<String> searchWords) {
        this.searchWords = searchWords;
    }

    public void setTableBuilder(String tableBuilder) {
        this.tableBuilder = tableBuilder;
    }
}

