package wordProcessor.util.validator;

import wordProcessor.util.validator.exceptions.InvalidAccptbleWrdsFileFormatException;
import wordProcessor.util.validator.exceptions.InvalidInputFileFormatException;
import wordProcessor.util.validator.exceptions.InvalidInputParamsException;

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
        public void validateInputParameters(String baseErrMsg, ValidatorI... validators)
                        throws InvalidInputParamsException;

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
                        throws InvalidInputFileFormatException;

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
                        throws InvalidAccptbleWrdsFileFormatException;

}