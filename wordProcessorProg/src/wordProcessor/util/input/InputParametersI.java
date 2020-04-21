package expenseManager.util.input;

/**
 * InputParametersI interface - Contains methods for storing and retrieving
 * command line arguments passed to the application
 * 
 * @author Kenneth Peter Fernandes
 */
public interface InputParametersI {

    /**
     * Function to store the Input file path
     * 
     * @param path - Command-line argument for File path
     */
    public void setInputFilePath(String path);

    /**
     * Function to retrieve the Input file path
     * 
     * @return - Input file path
     */
    public String getInputFilePath();

    /**
     * Function to store the Available Items file path
     * 
     * @param path - Command-line argument for File path
     */
    public void setAvailableItemsFilePath(String path);

    /**
     * Function to retrieve the Available Items file path
     * 
     * @return - Available Items file path
     * 
     */
    public String getAvailableItemsFilePath();

    /**
     * Function to store the running average window to be used
     * 
     * @param runAvgWinSizeStr - Command-line argument for running average window
     *                         size
     */
    public void setRunAvgWinSize(String runAvgWinSizeStr);

    /**
     * Function to retrieve the runnning average window
     * 
     * @return - Running average window size
     */
    public int getRunAvgWinSize();

    /**
     * Function to store the Output file path
     * 
     * @param path - Command-line argument for File path
     */
    public void setOutputFilePath(String path);

    /**
     * Function to retrieve the Output file path
     * 
     * @return - Output file path
     */
    public String getOutputFilePath();

}