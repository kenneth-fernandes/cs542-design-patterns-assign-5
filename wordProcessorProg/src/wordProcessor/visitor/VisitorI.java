package wordProcessor.visitor;

import wordProcessor.element.ElementI;
import wordProcessor.element.MyElement;

public interface VisitorI {

    public void visit(MyElement element);
}