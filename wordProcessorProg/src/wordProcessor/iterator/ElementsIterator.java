package wordProcessor.iterator;

import java.util.ArrayList;

import wordProcessor.element.ElementI;

public class ElementsIterator implements IteratorI {
    private ArrayList<ElementI> myArrayList;
    private int index;

    public ElementsIterator(ArrayList<ElementI> inMyArrayList) {
        myArrayList = inMyArrayList;
    }

    @Override
    public boolean hasNext() {
        if (index < myArrayList.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        if (this.hasNext()) {
            return myArrayList.get(index++);
        }
        return null;
    }

}