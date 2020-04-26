package wordProcessor.results;

import java.io.IOException;

/**
 * 
 */
public class SpellCheckResults implements ResultsI {
    //
    private String fileName;

    public SpellCheckResults(String inFileName) {
        fileName = inFileName;
    }

    @Override
    public void writeToFile() throws IOException {
        

    }
    
    @Override
    public void storeResults(String result) {

    }
    
}