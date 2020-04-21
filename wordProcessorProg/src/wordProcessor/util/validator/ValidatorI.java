package expenseManager.util.validator;

/**
 * ValidatorI interface - Contains the function signatue that executes the
 * validatior
 * 
 * @author - Kenneth Peter Fernandes
 */
public interface ValidatorI {
    /**
     * The functions executes instructions for performing the validation based the
     * requirement
     * 
     * @throws Exception - The user-defined exceptions based on the validation
     *                   functions
     */
    void run() throws Exception;
}
