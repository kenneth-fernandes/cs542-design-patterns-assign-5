package wordProcessor.element;

import java.util.ArrayList;
import java.util.Arrays;

import wordProcessor.iterator.ElementWordsIterator;
import wordProcessor.iterator.IteratorI;
import wordProcessor.visitor.VisitorI;

public class MyElement implements ElementI {

    private ArrayList<String> wordsList;

    public MyElement(String inSentence) {
        wordsList = new ArrayList<String>(Arrays.asList(inSentence.split("\\s")));
    }

    @Override
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }

    @Override
    public IteratorI getIterator() {
        return new ElementWordsIterator(wordsList);
    }
}