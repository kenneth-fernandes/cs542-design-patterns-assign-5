package wordProcessor.element;

import wordProcessor.iterator.IteratorI;
import wordProcessor.visitor.VisitorI;

public interface ElementI {

    public void accept(VisitorI visitor);

    public IteratorI getIterator();

}