package wordProcessor.iterator;

import java.util.ArrayList;

/**
 * ElementWordsIterator class - Contains implemented methods of IteratorI
 * interface for perforing iteration over ArrayList<String>
 * 
 * @author - Kenneth Peter Fernandes
 */
public class ElementWordsIterator implements IteratorI {
    // Stores the index of the iterator
    private int index;
    // Stores the words data that needs to be iterated
    private ArrayList<String> wordsList;

    /**
     * ElementWordsIterator class constructor - Intializes the words list
     * 
     * @param inWrdsList - List of words of a sentence
     */
    public ElementWordsIterator(ArrayList<String> inWrdsList) {
        wordsList = inWrdsList;
    }

    /**
     * Returns the boolean value "true or false" if the Data-Structure has elements
     * to be iterated or not
     * 
     * @return - Boolean value "true or false"
     */
    @Override
    public boolean hasNext() {
        if (index < wordsList.size()) {
            return true;
        }
        return false;
    }

    /**
     * Returns the next element that is iterated
     * 
     * @return - The element that is iterated
     */
    @Override
    public Object next() {
        if (this.hasNext()) {
            return wordsList.get(index++);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Class: ElementWordsIterator, DataMembers: [ index: " + index + ", wordsList: " + wordsList.toString()
                + " ]";
    }

}