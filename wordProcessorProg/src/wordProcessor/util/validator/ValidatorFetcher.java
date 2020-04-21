package expenseManager.util.validator;

import java.io.File;

import expenseManager.util.constants.ExceptionConstants;
import expenseManager.util.constants.ItemCostTypeConstants;
import expenseManager.util.constants.UtilConstants;
import expenseManager.util.constants.ValidationConditionConstants;

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
    public ValidatorI inputFilePathValidatn(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (input.isBlank() || input.isEmpty()) {
                    throw new Exception(ExceptionConstants.INPUT_FILE_PATH_EMPTY_ERROR_MSG.getErrorMsg());
                }
            }
        };
    }

    /**
     * The function performs validation of available items filepath parameter
     * 
     * @param input - The input parameter entered for available items file-path
     * @return - The implemented interface ValidatorI performing the available items
     *         filepath parameter validation
     */
    public ValidatorI availItmFilePathValidatn(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (input.isBlank() || input.isEmpty()) {
                    throw new Exception(ExceptionConstants.AVAILABLE_ITEM_FILE_PATH_EMPTY_ERROR_MSG.getErrorMsg());
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
    public ValidatorI runAvgWinSizeValidatn(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (input.isBlank() || input.isEmpty()) {
                    throw new Exception(ExceptionConstants.WINDOW_SIZE_PARAMETER_EMPTY_ERROR_MSG.getErrorMsg());
                } else {
                    try {
                        int value = Integer.parseInt(input);
                        if (value <= 0) {
                            throw new Exception(
                                    ExceptionConstants.WINDOW_SIZE_PARAMETER_NEGATIVE_VALUE_ERROR_MSG.getErrorMsg());
                        }
                    } catch (NumberFormatException e) {
                        throw new Exception(
                                ExceptionConstants.WINDOW_SIZE_PARAMETER_INVALID_FORMAT_ERROR_MSG.getErrorMsg());
                    }

                }
            }
        };
    }

    /**
     * The function performs validation of output filepath parameter
     * 
     * @param input - The input parameter entered for output file-path
     * @return - The implemented interface ValidatorI performing the output filepath
     *         parameter validation
     */
    public ValidatorI outputFilePathValidatn(String input) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (input.isBlank() || input.isEmpty()) {
                    throw new Exception(ExceptionConstants.OUTPUT_FILE_PATH_EMPTY_ERROR_MSG.getErrorMsg());
                }
            }
        };
    }

    /**
     * The function performs validation of input file empty
     * 
     * @param file - File object of the input file
     * @return - The implemented interface ValidatorI performing the input file
     *         empty validation
     */
    public ValidatorI inputFileEmptyValidatn(File file) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                if (file.length() == 0) {
                    throw new Exception(
                            ExceptionConstants.INPUT_AVAILABLE_ITEMS_FILE_CONTENTS_EMPTY_ERROR_MSG.getErrorMsg());
                }
            }
        };
    }

    /**
     * The function performs validation of available items data format
     * 
     * @param data - Data from available items file
     * @return - The implemented interface ValidatorI performing the available items
     *         data format validation
     */
    public ValidatorI availItmFileFormatValidn(String data) {
        return new ValidatorI() {
            @Override
            public void run() throws Exception {
                // Checking if data is empty
                if (data.isBlank() || data.isEmpty()) {
                    throw new Exception(ExceptionConstants.AVAILABLE_ITEM_FILE_DATA_EMPTY_ERROR_MSG.getErrorMsg());
                }
                // Checking if the data matches the available item data format
                else if (!data.matches(ValidationConditionConstants.AVAILABLE_ITEM_FORMAT_REG_EXP.getConstantValue())) {
                    throw new Exception(
                            ExceptionConstants.AVAILABLE_ITEM_FILE_DATA_INCORRECT_FORMAT_ERROR_MSG.getErrorMsg());
                }
                // Checking if the available item file has invalid types of item
                else if (!data.split(UtilConstants.COLON_CHAR.getConstantValue())[0]
                        .equals(ItemCostTypeConstants.BASIC_ITEM.getConstantValue())
                        && !data.split(UtilConstants.COLON_CHAR.getConstantValue())[0]
                                .equals(ItemCostTypeConstants.MODERATERATLY_EXPENSIVE_ITEM.getConstantValue())
                        && !data.split(UtilConstants.COLON_CHAR.getConstantValue())[0]
                                .equals(ItemCostTypeConstants.SUPER_EXPENSIVE_ITEM.getConstantValue())) {
                    throw new Exception(
                            ExceptionConstants.AVAILABLE_ITEM_FILE_DATA_INCORRECT_FORMAT_ERROR_MSG.getErrorMsg());
                }
                // Checking if available item name is not a whole number
                else if (data
                        .matches(ItemCostTypeConstants.BASIC_ITEM.getConstantValue()
                                + UtilConstants.COLON_CHAR.getConstantValue()
                                + ValidationConditionConstants.NUMBER_REG_EXP.getConstantValue())
                        || data.matches(ItemCostTypeConstants.MODERATERATLY_EXPENSIVE_ITEM.getConstantValue()
                                + UtilConstants.COLON_CHAR.getConstantValue()
                                + ValidationConditionConstants.NUMBER_REG_EXP.getConstantValue())
                        || data.matches(ItemCostTypeConstants.SUPER_EXPENSIVE_ITEM.getConstantValue()
                                + UtilConstants.COLON_CHAR.getConstantValue()
                                + ValidationConditionConstants.NUMBER_REG_EXP.getConstantValue())) {
                    throw new Exception(
                            ExceptionConstants.AVAILABLE_ITEM_FILE_DATA_NUMERIC_ITEM_NAME_ERROR_MSG.getErrorMsg());
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
            public void run() throws Exception {
                // Checking if data is empty
                if (data.isBlank() || data.isEmpty()) {
                    throw new Exception(ExceptionConstants.INPUT_FILE_DATA_EMPTY_ERROR_MSG.getErrorMsg());
                }
                // Checking if the data matches the input file data format
                else if (!data.matches(ValidationConditionConstants.INPUT_ITEM_FORMAT_REG_EXP.getConstantValue())
                        && !data.matches(ValidationConditionConstants.INPUT_MONEY_FORMAT_REG_EXP.getConstantValue())) {
                    throw new Exception(ExceptionConstants.INPUT_FILE_DATA_INCORRECT_FORMAT_ERROR_MSG.getErrorMsg());
                }
                // Checking if the data matches the input file data format
                else if (!data.split(UtilConstants.COLON_CHAR.getConstantValue())[0]
                        .equals(UtilConstants.ITEM.getConstantValue())
                        && !data.split(UtilConstants.COLON_CHAR.getConstantValue())[0]
                                .equals(UtilConstants.MONEY.getConstantValue())) {
                    throw new Exception(ExceptionConstants.INPUT_FILE_DATA_INCORRECT_FORMAT_ERROR_MSG.getErrorMsg());
                }
                // Checking if the money is a valid number
                else if (data.split(UtilConstants.COLON_CHAR.getConstantValue())[0]
                        .equals(UtilConstants.MONEY.getConstantValue())) {
                    try {
                        int num = Integer.parseInt(data.split(UtilConstants.MONEY.getConstantValue()
                                + UtilConstants.COLON_CHAR.getConstantValue())[1]);
                        if (num <= 0)
                            throw new Exception(
                                    ExceptionConstants.INPUT_FILE_MONEY_DATA_INCORRECT_FORMAT_ERROR_MSG.getErrorMsg());
                    } catch (NumberFormatException e) {
                        throw new Exception(
                                ExceptionConstants.INPUT_FILE_MONEY_INCORRECT_INTEGER_FORMAT_ERROR_MSG.getErrorMsg());
                    }

                }
            }
        };
    }

    @Override
    public String toString() {
        return "Class: ValidatorFetcher, Data Members: [ validatrFetchrObj: " + validatrFetchrObj.toString() + "]";
    }

}