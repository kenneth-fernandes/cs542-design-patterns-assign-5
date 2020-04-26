package wordProcessor.persister;

import java.io.IOException;

/**
 * DataPersisterToFileI interface - Contains functions for writing data to file
 * 
 * @author Kenneth Peter Fernandes
 */
public interface DataPersisterToFileI {
    /**
     * This function writes data to bufferedWrite
     * 
     * @param dataStr - The data of type String
     */
    public void writeLine(String dataStr) throws IOException;

    /**
     * This function closes the file connection and flushes the buffrdWriter to the
     * file
     * 
     * @throws IOException - Exception caused while Input/Output thrown by the
     *                     function
     */
    public void closeFile() throws IOException;

}