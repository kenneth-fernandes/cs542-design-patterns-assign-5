package wordProcessor.persister;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/**
 * DataPersisterToFile class - Implements the DataPersisterToFileI interface
 * functions for writing data to file
 * 
 * @author Kenneth Peter Fernandes
 */
public class DataPersisterToFile implements DataPersisterToFileI {

    // Stores the BufferedWriter instance
    private BufferedWriter buffrdWriter;

    // Stores the File instance
    private File file;

    // Stores the FileWriter instance
    private FileWriter fileWriter;

    /**
     * DataPersisterToFile constructor that intializes fileWriter and bufferedWriter
     * 
     * @param filePath - Output file path
     * @throws FileNotFoundException - Exception caused while Input/Output thrown by
     *                               the function
     * @throws IOException           - Exception caused while Input/Output thrown by
     *                               the function
     */
    public DataPersisterToFile(String filePath) throws FileNotFoundException, IOException {
        try {
            file = new File(filePath);
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file);
            buffrdWriter = new BufferedWriter(fileWriter);
        } catch (FileNotFoundException e) {
            throw e;
        }
    }

    /**
     * This function writes data to bufferedWrite
     * 
     * @param dataStr - The data of type String
     */
    public void writeLine(String dataStr) throws IOException {
        System.out.println(dataStr);
        buffrdWriter.write(dataStr.trim());
    }

    /**
     * This function closes the file connection and flushes the buffrdWriter to the
     * file
     * 
     * @throws IOException - Exception caused while Input/Output thrown by the
     *                     function
     */
    public void closeFile() throws IOException {
        try {
            buffrdWriter.flush();
            if (buffrdWriter != null)
                buffrdWriter.close();
        } catch (IOException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return "Class: PersistToFile, Data Members : [ buffrdWriter:" + buffrdWriter + ", file: " + file
                + ", fileWriter:" + fileWriter + "]";
    }
}