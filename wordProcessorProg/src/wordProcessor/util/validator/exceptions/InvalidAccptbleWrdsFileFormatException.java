package wordProcessor.util.validator.exceptions;

/**
 * InvalidAccptbleWrdsFileFormatException class
 * 
 * @author Kenneth Peter Fernandes
 */
public class InvalidAccptbleWrdsFileFormatException extends Exception {
    /**
     * Serial number constant
     */
    private static final long serialVersionUID = 1L;

    /**
     * InvalidInputParamsException constructor calling the parent class object
     * 
     * @param s - The error message
     */
    public InvalidAccptbleWrdsFileFormatException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "Class: InvalidAccptbleWrdsFileFormatException, Data Members: [ ]";
    }
}