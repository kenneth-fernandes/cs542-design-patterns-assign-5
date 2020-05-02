package wordProcessor.element;

import java.io.IOException;
import java.util.ArrayList;

import wordProcessor.element.ElementI;
import wordProcessor.iterator.ElementsIterator;
import wordProcessor.iterator.IteratorI;
import wordProcessor.util.fileprocess.FileProcessorI;
import wordProcessor.util.validator.ValidatorFetcher;
import wordProcessor.util.validator.ValidatorFetcherI;
import wordProcessor.util.validator.ValidatorUtil;
import wordProcessor.util.validator.ValidatorUtilI;
import wordProcessor.util.validator.exceptions.InvalidInputFileFormatException;
import wordProcessor.visitor.VisitorI;

/**
 * MyArrayList class - Contains implemented methods of ElementI interface and
 * also contains Builder class that processes the sentences read from the input
 * file.
 * 
 * @author - Kenneth Peter Fernandes
 */
public class MyArrayList implements ElementI {
    // Stores the interface ElementI for MyArrayList instance
    private static ElementI myArrayListObj = new MyArrayList();
    // Stores the ArrayList of type ElementI
    private static ArrayList<ElementI> myArrayList = new ArrayList<ElementI>();

    /**
     * Builder class (static) - Performs the function of processing the sentences in
     * the input file and builds the ArrayList<ElementI> object for further
     * analysis.
     * 
     * @author - Kenneth Peter Fernandes
     */
    public static class Builder {
        // Store the line read from the input file
        private String line = "";
        // Stores the sentences that is formed by processing each line fron input file
        private String sentence = "";

        public Builder withFileProcessor(FileProcessorI fileProcessor)
                throws IOException, InvalidInputFileFormatException {

            // Stores the interface of ValidatorUtilI for ValidatorUtil instance
            ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
            // Stores the interface of ValidatorFetcherI for ValidatorFetcher instance
            ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();

            /**
             * Processing the line read from the input file into sentences
             */
            while ((line = fileProcessor.readLine()) != null) {
                // Validation of each line read for input file
                validatrUtilObj.validateInputFileData("Input-file data error",
                        validatrFetchrObj.inputFileDataFormatValidn(line));

                if (line.indexOf(".") >= 0) {
                    String[] lineArr = line.split("\\.");

                    for (int index = 0; index < lineArr.length - 1; index += 1) {
                        if (!sentence.trim().isEmpty()) {
                            lineArr[index] = sentence.concat(lineArr[index]);
                            sentence = "";
                        }
                        myArrayList.add(new MyElement(lineArr[index].trim()));
                    }
                    sentence = sentence.concat(lineArr[lineArr.length - 1]);

                    if (line.lastIndexOf(".") == line.length() - 1) {
                        myArrayList.add(new MyElement(sentence.trim()));
                        sentence = "";
                    }
                } else {
                    sentence = sentence.concat(line);
                }
            }

            if (!sentence.trim().isEmpty()) {
                myArrayList.add(new MyElement(sentence.trim()));
            }
            // CLosing the file processor
            fileProcessor.closeFile();

            return new Builder();
        }

        /**
         * Returns the interface ElementI of MyArrayList instance
         * 
         * @return
         */
        public ElementI build() {
            return myArrayListObj;
        }

        @Override
        public String toString() {
            return "Class: Builder (static), DataMembers[ line: " + line + ", myArrayList: " + myArrayList.toString()
                    + "]";
        }

    }

    /**
     * The function accepts visitors to perform sentence processing analysis
     * 
     * @param visitor - Visitors that perform sentence processing analysis
     */
    @Override
    public void accept(VisitorI visitor) {
        IteratorI elemIterator = this.getIterator();
        while (elemIterator.hasNext()) {
            ((ElementI) elemIterator.next()).accept(visitor);
        }
    }

    /**
     * The function returns IteratorI interface for a particular data-structor
     * iterator
     * 
     * @return - IteratorI interface for a particular data-structor iterator
     */
    @Override
    public IteratorI getIterator() {
        return new ElementsIterator(myArrayList);
    }

    @Override
    public String toString() {
        return "Class: MyArrayList, DataMembers[ myArrayListObj: " + myArrayListObj.toString() + ", myArrayList: "
                + myArrayList.toString() + "]";
    }

}