package wordProcessor.element;

import java.util.ArrayList;
import java.util.Arrays;

import wordProcessor.iterator.ElementWordsIterator;
import wordProcessor.iterator.IteratorI;
import wordProcessor.visitor.VisitorI;

public class MyElement implements ElementI {
    // Stores the list of words in each sentence
    private ArrayList<String> wordsList;

    /**
     * MyElement class contstructor - Initializing the list of words ArrayList
     * 
     * @param inSentence - Sentence read from the input file
     */
    public MyElement(String inSentence) {
        wordsList = new ArrayList<String>(Arrays.asList(inSentence.split("\\s")));
    }

    /**
     * The function accepts visitors to perform sentence processing analysis
     * 
     * @param visitor - Visitors that perform sentence processing analysis
     */
    @Override
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }

    /**
     * The function returns IteratorI interface for a particular data-structor
     * iterator
     * 
     * @return - IteratorI interface for a particular data-structor iterator
     */
    @Override
    public IteratorI getIterator() {
        return new ElementWordsIterator(wordsList);
    }

    @Override
    public String toString() {
        return "Class: MyElement, DataMembers: [ wordsList: " + wordsList + " ]";
    }
}