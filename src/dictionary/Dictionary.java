package dictionary;

import java.util.ArrayList;

public class Dictionary {
    private ArrayList<Word> words = new ArrayList<>();

    public void setWords(ArrayList<Word> words) {
        this.words = words;
    }

    public ArrayList<Word> getWords() {
        return words;
    }

    public Word lookUp(String wordSearch) {
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).getWord_target().equalsIgnoreCase(wordSearch)) {
                return words.get(i);
            }
        }
        return null;
    }
}
