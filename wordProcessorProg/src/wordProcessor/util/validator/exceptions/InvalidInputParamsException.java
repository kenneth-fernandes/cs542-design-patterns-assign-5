package wordProcessor.util.validator.exceptions;

/**
 * InvalidInputParamsException class
 * 
 * @author Kenneth Peter Fernandes
 */
public class InvalidInputParamsException extends Exception {
    /**
     * Serial number constant
     */
    private static final long serialVersionUID = 1L;

    /**
     * InvalidInputParamsException constructor calling the parent class object
     * 
     * @param s - The error message
     */
    public InvalidInputParamsException(String s) {
        super(s);
    }

    @Override
    public String toString() {
        return "Class: InvalidInputParamsException, Data Members: [ ]";
    }
}