package wordProcessor.visitor;

import wordProcessor.element.ElementI;

/**
 * 
 */
public interface VisitorI {

    /**
     * 
     * @param element
     */
    public void visit(ElementI element);
}