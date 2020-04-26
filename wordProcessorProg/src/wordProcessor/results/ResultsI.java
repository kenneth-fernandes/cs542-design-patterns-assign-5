package wordProcessor.results;

import java.io.IOException;

public interface ResultsI {
    public void writeToFile() throws IOException;
    
    public void storeResults(String result);

}