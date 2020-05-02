package wordProcessor.visitor;

import wordProcessor.element.ElementI;

/**
 * VisitorI interface - Contains method to visit a
 */
public interface VisitorI {

    /**
     * Vists the element that contains sentences by each sentence analyzer
     * 
     * @param element - Sentence wrapped into ElementI interface for MyElement
     *                instance
     */
    public void visit(ElementI element);
}