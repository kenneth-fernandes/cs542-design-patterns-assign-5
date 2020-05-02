package wordProcessor.iterator;

/**
 * IteratorI interface - Contains methods required for performing data-structure
 * elements iteration
 * 
 * @author - Kenneth Peter Fernandes
 */
public interface IteratorI {
    /**
     * Returns the boolean value "true or false" if the Data-Structure has elements
     * to be iterated or not
     * 
     * @return - Boolean value "true or false"
     */
    public boolean hasNext();

    /**
     * Returns the next element that is iterated
     * 
     * @return - The element that is iterated
     */
    public Object next();

}