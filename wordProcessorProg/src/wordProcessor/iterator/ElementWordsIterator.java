package wordProcessor.iterator;

import java.util.ArrayList;

public class ElementWordsIterator implements IteratorI {

    private int index;

    private ArrayList<String> wordsList;

    public ElementWordsIterator(ArrayList<String> inWrdsList) {
        wordsList = inWrdsList;
    }

    @Override
    public boolean hasNext() {
        if (index < wordsList.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return wordsList.get(index++);
        }
        return null;
    }

}