package wordProcessor.visitor;

import wordProcessor.element.MyElement;

/**
 * 
 */
public interface VisitorI {

    /**
     * 
     * @param element
     */
    public void visit(MyElement element);
}