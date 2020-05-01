package wordProcessor.element;

import wordProcessor.iterator.IteratorI;
import wordProcessor.visitor.VisitorI;

/**
 * ElementI interface - Contains functions to accept visitors and retriving
 * iterator for a particular data-structure
 * 
 * @author - Kenneth Peter Fernandes
 */
public interface ElementI {
    /**
     * The function accepts visitors to perform sentence processing analysis
     * 
     * @param visitor - Visitors that perform sentence processing analysis
     */
    public void accept(VisitorI visitor);

    /**
     * The function returns IteratorI interface for a particular data-structor
     * iterator
     * 
     * @return - IteratorI interface for a particular data-structor iterator
     */
    public IteratorI getIterator();

}