package wordProcessor.element;

import java.util.Iterator;

import wordProcessor.visitor.VisitorI;

public interface ElementI {

    public void accept(VisitorI visitor);

    public Iterator<?> getIterator();

}