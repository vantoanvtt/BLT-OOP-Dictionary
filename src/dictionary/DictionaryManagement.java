package dictionary;

import java.util.ArrayList;

public class DictionaryManagement {
    private Dictionary dictionary = new Dictionary();

    public DictionaryManagement(ArrayList<Word> listWord) {
        dictionary.setWords(listWord);
    }

    /*public Word binarySearch(String WordSearch) {
        ArrayList<Word> words = dictionary.getWords();
        int l = 0, h = words.size() - 1;
        while (l <= h) {
            int m = l + (h - l) / 2;
            if (words.get(m).getWord_target() == WordSearch) {
                return words.get(m);
            } else if () {

            }
        }
    }*/
    public Word getWordSearch (String word) {
        return dictionary.lookUp(word);
    }

}
