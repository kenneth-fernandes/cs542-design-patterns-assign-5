package expenseManager.util.validator;

import expenseManager.util.constants.UtilConstants;
import expenseManager.util.validator.expception.FileNotProcessedException;
import expenseManager.util.validator.expception.InvalidAvailItemFileFormatException;
import expenseManager.util.validator.expception.InvalidInputFileFormatException;
import expenseManager.util.validator.expception.InvalidInputParamsException;

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
    public void validateInputParams(String baseErrMsg, ValidatorI... validators) throws InvalidInputParamsException {
        for (ValidatorI validator : validators) {
            try {
                validator.run();
            } catch (Exception e) {
                throw new InvalidInputParamsException(baseErrMsg.concat(UtilConstants.COLON_CHAR.getConstantValue()
                        + UtilConstants.SINGLE_SPACE.getConstantValue() + e.getMessage()));
            }
        }

    }

    /**
     * The function executes each ValidatorI's implemented functions for file
     * processor validation
     * 
     * @param baseErrMsg - Base error message
     * @param validators - Array of ValidatorI interfaces
     * @throws FileNotProcessedException - File not processed exception
     */
    public void validateFileProcessor(String baseErrMsg, ValidatorI... validators) throws FileNotProcessedException {
        for (ValidatorI validator : validators) {
            try {
                validator.run();
            } catch (Exception e) {
                throw new FileNotProcessedException(baseErrMsg.concat(UtilConstants.COLON_CHAR.getConstantValue()
                        + UtilConstants.SINGLE_SPACE.getConstantValue() + e.getMessage()));
            }
        }

    }

    /**
     * The function executes each ValidatorI's implemented functions for available
     * items file data validation
     * 
     * @param baseErrMsg - Base error message
     * @param validators - Array of ValidatorI interfaces
     * @throws InvalidAvailItemFileFormatException - Invalid available items file
     *                                             format exception
     */
    public void validateAvailItemFileData(String baseErrMsg, ValidatorI... validators)
            throws InvalidAvailItemFileFormatException {
        for (ValidatorI validator : validators) {
            try {
                validator.run();
            } catch (Exception e) {
                throw new InvalidAvailItemFileFormatException(
                        baseErrMsg.concat(UtilConstants.COLON_CHAR.getConstantValue()
                                + UtilConstants.SINGLE_SPACE.getConstantValue() + e.getMessage()));
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
                throw new InvalidInputFileFormatException(baseErrMsg.concat(UtilConstants.COLON_CHAR.getConstantValue()
                        + UtilConstants.SINGLE_SPACE.getConstantValue() + e.getMessage()));
            }
        }

    }

    @Override
    public String toString() {
        return "Class: ValidatorUtil, Data Members: [ validatorUtilObj: " + validatorUtilObj.toString() + "]";
    }
}