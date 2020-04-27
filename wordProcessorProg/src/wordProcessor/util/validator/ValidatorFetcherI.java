package wordProcessor.util.validator;

/**
 * ValidatorFetcherI interface - Contains the functions signature that performs
 * validations
 * 
 * @author - Kenneth Peter Fernandes
 */
public interface ValidatorFetcherI {

    /**
     * The function performs validation of filepath parameter
     * 
     * @param filePath - The input parameter entered for file-path
     * @return - The implemented interface ValidatorI performing the filepath
     *         parameter validation
     */
    public ValidatorI filePathValidation(String filePath);

    /**
     * The function performs validation of window size parameter used for running
     * average calculation
     * 
     * @param input - The input parameter entered for window size
     * @return - The implemented interface ValidatorI performing validation of
     *         window size parameter
     */
    public ValidatorI kValueValidation(String input);

    /**
     * The function performs validation of input data format
     * 
     * @param data - Data from the input file
     * @return - The implemented interface ValidatorI performing the input data
     *         format validation
     */
    public ValidatorI inputFileFormatValidn(String data);

    /**
     * The function performs validation of acceptable words file data format
     * 
     * @param data - Data from the acceptable words file
     * @return The implemented interface ValidatorI performing the acceptable words
     *         data format validation
     */
    public ValidatorI acceptbleWrdsFileFormatValidn(String data);

}