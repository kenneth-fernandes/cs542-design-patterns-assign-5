package wordProcessor.results;

import java.io.IOException;

import wordProcessor.persister.DataPersisterToFile;
import wordProcessor.persister.DataPersisterToFileI;

/**
 * TopKFreqWordsResults class: Contains implemented methods of ResultsI
 * interface for performing Top K Frequent words analysis on the sentence
 * 
 * @author - Kenneth Peter Fernandes
 * 
 */
public class TopKFreqWordsResults implements ResultsI {
    // Stores the file name for storing the output
    private String outputFileName;
    // Stores the DataPersisterToFileI interface for DataPersisterToFile instance
    private DataPersisterToFileI dataPersister;
    // Stores the final top K frequent words result
    private String result = "";

    /**
     * TopKFreqWordsResults class constructor: Initializes the outputFileName and
     * dataPersister
     * 
     * @param inFileName - File name of output file
     * @throws IOException - Exception occured during I/O operations
     */
    public TopKFreqWordsResults(String inFileName) throws IOException {
        outputFileName = inFileName;
        dataPersister = new DataPersisterToFile(outputFileName);
    }

    /**
     * Stores the top k frequent words result of the a particular analysis on a
     * sentence
     * 
     * @param result - Result of the a particular analysis on a sentence
     */
    @Override
    public void storeResults(String inResult) {
        result = result.concat(inResult);
    }

    /**
     * Persists the top k frequent words result stored into the output file
     * 
     * @throws IOException - Exception occurred due to I/O operations
     */
    @Override
    public void writeToFile() throws IOException {
        dataPersister.writeLine(result);
        dataPersister.closeFile();
    }

    @Override
    public String toString() {
        return "Class: SpellCheckResults, DataMembers: [ outputFileName: " + outputFileName + ", dataPersister: "
                + dataPersister.toString() + ", result: " + result + " ]";
    }

}