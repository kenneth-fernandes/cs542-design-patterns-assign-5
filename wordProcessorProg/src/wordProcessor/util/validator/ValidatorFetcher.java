package wordProcessor.util.validator;

import wordProcessor.util.validator.exceptions.InvalidAccptbleWrdsFileFormatException;
import wordProcessor.util.validator.exceptions.InvalidInputFileFormatException;
import wordProcessor.util.validator.exceptions.InvalidInputParamsException;

/**
 * ValidatorFetcher class - Implements the ValidatorFetcherI interface functions
 * for performing validations
 * 
 * @author - Kenneth Peter Fernandes
 */
public class ValidatorFetcher implements ValidatorFetcherI {
    // The variable hold the interface of ValidatorFetcher instance
    private static ValidatorFetcherI validatrFetchrObj = new ValidatorFetcher();

    /**
     * The function returns the interface of ValidatorFetcher object's single
     * instance
     * 
     * @return - Interface of ValidatorFetcher object
     * 
     */
    public static ValidatorFetcherI getInstance() {
        return validatrFetchrObj;
    }

    /**
     * Private ValidatorFetcher empty constructor
     */
    private ValidatorFetcher() {
    }

    /**
     * The function performs validation of input filepath parameter
     * 
     * @param input - The input parameter entered for input file-path
     * @return - The implemented interface ValidatorI performing the input filepath
     *         parameter validation
     */
    public ValidatorI filePathValidation(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws InvalidInputParamsException {
                if (input.isBlank() || input.isEmpty()) {
                    throw new InvalidInputParamsException("The file path entered is empty.");
                }
            }
        };
    }

    /**
     * The function performs validation of window size parameter used for running
     * average calculation
     * 
     * @param input - The input parameter entered for window size
     * @return - The implemented interface ValidatorI performing validation of
     *         window size parameter
     */
    public ValidatorI kValueValidation(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws InvalidInputParamsException {
                if (input.isBlank() || input.isEmpty()) {
                    throw new InvalidInputParamsException("The input parameter entered for k is empty.");
                } else {
                    try {
                        int value = Integer.parseInt(input);
                        if (value <= 0) {
                            throw new InvalidInputParamsException(
                                    "The input parameter entered for k is a negative number or zero.");
                        }
                    } catch (NumberFormatException e) {
                        throw new InvalidInputParamsException(
                                "The input parameter entered for k is not a correct integer format.");
                    }

                }
            }
        };
    }

    /**
     * The function performs validation of input data format
     * 
     * @param data - Data from the input file
     * @return - The implemented interface ValidatorI performing the input data
     *         format validation
     */
    public ValidatorI inputFileFormatValidn(String data) {
        return new ValidatorI() {
            @Override
            public void run() throws InvalidInputFileFormatException {
                // Checking if data is empty
                if (data.isBlank() || data.isEmpty()) {
                    throw new InvalidInputFileFormatException("The data read from the input file is empty.");
                }
                // Checking if the data matches the input file data format
                else if (!data.matches("[A-Za-z\\.\\s]+")) {
                    throw new InvalidInputFileFormatException(
                            "The data read from the input file is not of correct format that needs to contain "
                                    + "characters ranging from 'a-z', 'A-Z', periods and space.");
                }
            }
        };
    }

    /**
     * The function performs validation of acceptable words file data format
     * 
     * @param data - Data from the acceptable words file
     * @return The implemented interface ValidatorI performing the acceptable words
     *         data format validation
     */
    public ValidatorI acceptbleWrdsFileFormatValidn(String data) {
        return new ValidatorI() {
            @Override
            public void run() throws InvalidAccptbleWrdsFileFormatException {
                // Checking if data is empty
                if (data.isBlank() || data.isEmpty()) {
                    throw new InvalidAccptbleWrdsFileFormatException(
                            "The data read from the acceptable words file is empty.");
                }
                // Checking if the data matches the acceptable words file data format
                else if (!data.matches("[A-Za-z]+")) {
                    throw new InvalidAccptbleWrdsFileFormatException(
                            "The data read from the input file is not of correct format that needs to contain "
                                    + "characters ranging from 'a-z', 'A-Z'.");
                }
            }
        };
    }

    @Override
    public String toString() {
        return "Class: ValidatorFetcher, Data Members: [ validatrFetchrObj: " + validatrFetchrObj.toString() + "]";
    }

}