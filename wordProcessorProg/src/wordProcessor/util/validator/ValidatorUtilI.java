package expenseManager.util.validator;

import expenseManager.util.validator.expception.FileNotProcessedException;
import expenseManager.util.validator.expception.InvalidAvailItemFileFormatException;
import expenseManager.util.validator.expception.InvalidInputFileFormatException;
import expenseManager.util.validator.expception.InvalidInputParamsException;

/**
 * ValidatorUtilI interface - Contains the function signatures that perform
 * ValidatorI implemented functions
 * 
 * @author - Kenneth Peter Fernandes
 */
public interface ValidatorUtilI {
        /**
         * The function executes each ValidatorI's implemented functions for input
         * parameter validation
         * 
         * @param baseErrMsg - Base error message
         * @param validators - Array of ValidatorI interfaces
         * @throws InvalidInputParamsException - Invalid input parameter exception
         */
        public void validateInputParams(String baseErrMsg, ValidatorI... validators) throws InvalidInputParamsException;

        /**
         * The function executes each ValidatorI's implemented functions for file
         * processor validation
         * 
         * @param baseErrMsg - Base error message
         * @param validators - Array of ValidatorI interfaces
         * @throws FileNotProcessedException - File not processed exception
         */
        public void validateFileProcessor(String baseErrMsg, ValidatorI... validators) throws FileNotProcessedException;

        /**
         * The function executes each ValidatorI's implemented functions for available
         * items file data validation
         * 
         * @param baseErrMsg - Base error message
         * @param validators - Array of ValidatorI interfaces
         * @throws InvalidAvailItemFileFormatException - Invalid available items file format exception
         */
        public void validateAvailItemFileData(String baseErrMsg, ValidatorI... validators)
                        throws InvalidAvailItemFileFormatException;

        /**
         * The function executes each ValidatorI's implemented functions for input file
         * data validation
         * 
         * 
         * @param baseErrMsg - Base error message
         * @param validators - Array of ValidatorI interfaces
         * @throws InvalidInputFileFormatException - Invalid input file format
         *                                         exception
         */
        public void validateInputFileData(String baseErrMsg, ValidatorI... validators)
                        throws InvalidInputFileFormatException;

}