package wordProcessor.util.validator;

import wordProcessor.util.validator.exceptions.InvalidAccptbleWrdsFileFormatException;
import wordProcessor.util.validator.exceptions.InvalidInputFileFormatException;
import wordProcessor.util.validator.exceptions.InvalidInputParamsException;

/**
 * ValidatorUtil class - Implements the functions in ValidatorUtilI that
 * executes the list of various validators
 * 
 * @author - Kenneth Peter Fernandes
 */
public final class ValidatorUtil implements ValidatorUtilI {

    // The variable hold the interface of ValidatorUtil instance
    private static ValidatorUtilI validatorUtilObj = new ValidatorUtil();

    /**
     * Private ValidatorUtil empty constructor
     */
    private ValidatorUtil() {
    }

    /**
     * The function returns the interface of ValidatorUtil object's single instance
     * 
     * @return - Interface of ValidatorUtil object
     */
    public static ValidatorUtilI getInstance() {
        return validatorUtilObj;
    }

    /**
     * The function executes each ValidatorI's implemented functions for input
     * parameter validation
     * 
     * @param baseErrMsg - Base error message
     * @param validators - Array of ValidatorI interfaces
     * @throws InvalidInputParamsException - Invalid input parameter exception
     */
    public void validateInputParameters(String baseErrMsg, ValidatorI... validators) throws InvalidInputParamsException {
        for (ValidatorI validator : validators) {
            try {
                validator.run();
            } catch (Exception e) {
                throw new InvalidInputParamsException(baseErrMsg.concat(":" + " " + e.getMessage()));
            }
        }

    }

    /**
     * The function executes each ValidatorI's implemented functions for input file
     * data validation
     * 
     * 
     * @param baseErrMsg - Base error message
     * @param validators - Array of ValidatorI interfaces
     * @throws InvalidInputFileFormatException - Invalid input file format exception
     */
    public void validateInputFileData(String baseErrMsg, ValidatorI... validators)
            throws InvalidInputFileFormatException {
        for (ValidatorI validator : validators) {
            try {
                validator.run();
            } catch (Exception e) {
                throw new InvalidInputFileFormatException(baseErrMsg.concat(":" + " " + e.getMessage()));
            }
        }

    }

    /**
     * The function executes each ValidatorI's implemented functions for acceptable
     * words file data validation
     * 
     * 
     * @param baseErrMsg - Base error message
     * @param validators - Array of ValidatorI interfaces
     * @throws InvalidAccptbleWrdsFileFormatException - Invalid acceptable words
     *                                                file format exception
     */
    public void validateAcceptableWrdsFileData(String baseErrMsg, ValidatorI... validators)
            throws InvalidAccptbleWrdsFileFormatException {
        for (ValidatorI validator : validators) {
            try {
                validator.run();
            } catch (Exception e) {
                throw new InvalidAccptbleWrdsFileFormatException(baseErrMsg.concat(":" + " " + e.getMessage()));
            }
        }

    }
    @Override
    public String toString() {
        return "Class: ValidatorUtil, Data Members: [ validatorUtilObj: " + validatorUtilObj.toString() + "]";
    }
}