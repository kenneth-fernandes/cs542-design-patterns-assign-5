package wordProcessor.iterator;

import java.util.ArrayList;

import wordProcessor.element.ElementI;

/**
 * ElementsIterator class - Contains implemented methods of IteratorI interface
 * for perforing iteration over ArrayList<ElementsI>
 * 
 * @author - Kenneth Peter Fernandes
 */
public class ElementsIterator implements IteratorI {

    // Stores the index of the iterator
    private int index;
    // Stores the list of sentences wrapped in ElementI
    private ArrayList<ElementI> myArrayList;

    /**
     * ElementsIterator class constructor - Intializes the list that stores
     * sentences wrapped in ElementI
     * 
     * @param inMyArrayList - List of sentences wrapped in ElementI
     */
    public ElementsIterator(ArrayList<ElementI> inMyArrayList) {
        myArrayList = inMyArrayList;
    }

    /**
     * Returns the boolean value "true or false" if the Data-Structure has elements
     * to be iterated or not
     * 
     * @return - Boolean value "true or false"
     */
    @Override
    public boolean hasNext() {
        if (index < myArrayList.size()) {
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
            return myArrayList.get(index++);
        }
        return null;
    }

    @Override
    public String toString() {
        return "Class: ElementsIterator, DataMembers: [ index: " + index + ", myArrayList: " + myArrayList.toString()
                + " ]";
    }
}