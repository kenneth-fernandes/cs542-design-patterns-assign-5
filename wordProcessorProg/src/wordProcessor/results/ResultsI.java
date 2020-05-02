package wordProcessor.results;

import java.io.IOException;

/**
 * ResultsI interface: Contains functions for storing results and persisting
 * those results to the output file
 * 
 * @author - Kenneth Peter Fernandes
 * 
 */
public interface ResultsI {
    /**
     * Stores result of the a particular analysis on a sentence
     * 
     * @param result - Result of the a particular analysis on a sentence
     */
    public void storeResults(String result);

    /**
     * Persists the result stored into the output file
     * 
     * @throws IOException - Exception occurred due to I/O operations
     */
    public void writeToFile() throws IOException;

}