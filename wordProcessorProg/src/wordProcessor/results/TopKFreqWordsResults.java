package wordProcessor.results;

import java.io.FileNotFoundException;
import java.io.IOException;

import wordProcessor.persister.DataPersisterToFile;
import wordProcessor.persister.DataPersisterToFileI;

/**
 * 
 */
public class TopKFreqWordsResults implements ResultsI {
    //
    private String fileName;

    private DataPersisterToFileI dataPersister;

    private String result = "";

    public TopKFreqWordsResults(String inFileName) throws FileNotFoundException, IOException {
        fileName = inFileName;
        dataPersister = new DataPersisterToFile(fileName);
    }

    @Override
    public void writeToFile() throws IOException {
        dataPersister.writeLine(result);
        dataPersister.closeFile();
    }

    @Override
    public void storeResults(String inResult) {
        result = result.concat(inResult.concat("\n"));
    }

}