package expenseManager.util.validator;

import java.io.File;

/**
 * ValidatorFetcherI interface - Contains the functions signature that performs
 * validations
 * 
 * @author - Kenneth Peter Fernandes
 */
public interface ValidatorFetcherI {

    /**
     * The function performs validation of input filepath parameter
     * 
     * @param input - The input parameter entered for input file-path
     * @return - The implemented interface ValidatorI performing the input filepath
     *         parameter validation
     */
    public ValidatorI inputFilePathValidatn(String input);

    /**
     * The function performs validation of available items filepath parameter
     * 
     * @param input - The input parameter entered for available items file-path
     * @return - The implemented interface ValidatorI performing the available items
     *         filepath parameter validation
     */
    public ValidatorI availItmFilePathValidatn(String input);

    /**
     * The function performs validation of window size parameter used for running
     * average calculation
     * 
     * @param input - The input parameter entered for window size
     * @return - The implemented interface ValidatorI performing validation of
     *         window size parameter
     */
    public ValidatorI runAvgWinSizeValidatn(String input);

    /**
     * The function performs validation of output filepath parameter
     * 
     * @param input - The input parameter entered for output file-path
     * @return - The implemented interface ValidatorI performing the output filepath
     *         parameter validation
     */
    public ValidatorI outputFilePathValidatn(String input);

    /**
     * The function performs validation of input file empty
     * 
     * @param file - File object of the input file
     * @return - The implemented interface ValidatorI performing the input file
     *         empty validation
     */
    public ValidatorI inputFileEmptyValidatn(File file);

    /**
     * The function performs validation of available items data format
     * 
     * @param data - Data from available items file
     * @return - The implemented interface ValidatorI performing the available items
     *         data format validation
     */
    public ValidatorI availItmFileFormatValidn(String data);

    /**
     * The function performs validation of input data format
     * 
     * @param data - Data from the input file
     * @return - The implemented interface ValidatorI performing the input data
     *         format validation
     */
    public ValidatorI inputFileFormatValidn(String data);

}