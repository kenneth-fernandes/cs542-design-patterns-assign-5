package wordProcessor.element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import wordProcessor.visitor.VisitorI;

public class MyElement implements ElementI {

    private ArrayList<String> wordsList;

    public MyElement(String inSentence) {
        wordsList = new ArrayList<String>(Arrays.asList(inSentence.split(" ")));
    }

    @Override
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }

    @Override
    public Iterator<String> getIterator() {
        return wordsList.iterator();
    }
}