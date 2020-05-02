package wordProcessor.visitor;

import java.io.IOException;
import java.util.ArrayList;

import wordProcessor.element.ElementI;
import wordProcessor.iterator.IteratorI;
import wordProcessor.results.ResultsI;
import wordProcessor.util.fileprocess.FileProcessor;
import wordProcessor.util.fileprocess.FileProcessorI;
import wordProcessor.util.validator.ValidatorFetcher;
import wordProcessor.util.validator.ValidatorFetcherI;
import wordProcessor.util.validator.ValidatorUtil;
import wordProcessor.util.validator.ValidatorUtilI;
import wordProcessor.util.validator.exceptions.InvalidAccptbleWrdsFileFormatException;

/**
 * SpellCheckAnalyzer class - Contains implemented functions of VisitorI
 * interface for checking spelling of words in a sentence
 * 
 * @author - Kenneth Peter Fernandes
 */
public class SpellCheckAnalyzer implements VisitorI {
    // Stores the ResultsI interface for SpellCheckResults instance
    private ResultsI spellCheckAnalysisResults;
    // Stores the FileProcessorI interface for FileProcessor instance
    private FileProcessorI fileProcessor;
    // Stores the list of acceptable words
    private ArrayList<String> acceptableWrdsLst = new ArrayList<String>();
    // Stores the list of spell check words list for the misspelled word
    private ArrayList<String> spellCheckWrdsLst = new ArrayList<String>();
    // Stores the final result for Spell check analysis on a particular sentence
    private ArrayList<String> spellCheckResultsLst = new ArrayList<String>();
    // Stores the iterator of words list
    private IteratorI wordIterator;
    // Stores the wrong word
    private String wrongWrd = "";
    // Stores the line read from the input file of acceptable words
    private String line = "";
    // Stores the word that is currently being analysed
    private String word = "";
    // Stores the interface of ValidatorUtilI for ValidatorUtil instance
    private ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
    // Stores the interface of ValidatorFetcherI for ValidatorFetcher instance
    private ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();

    /**
     * SpellCheckAnalyzer class constructor - Intializes the
     * spellCheckAnalysisResults and all the acceptable words from the input file
     * 
     * @param inFileName - File name for acceptable words file
     * @param inResults  - ResultsI interface for SpellCheckResults instance
     * @throws IOException                            - Exception occured during I/O
     *                                                operations
     * @throws InvalidAccptbleWrdsFileFormatException - Exception occured due to
     *                                                invalid data format present in
     *                                                acceptable words file
     */
    public SpellCheckAnalyzer(String inFileName, ResultsI inResults)
            throws IOException, InvalidAccptbleWrdsFileFormatException {
        spellCheckAnalysisResults = inResults;
        processAcceptableWordsFromFile(inFileName);
    }

    /**
     * Vists the element that contains sentences by each sentence analyzer
     * 
     * @param element - Sentence wrapped into ElementI interface for MyElement
     *                instance
     */
    @Override
    public void visit(ElementI element) {
        // Invoking function for performing spell check analysis
        performSpellCheckAnalysis(element);
        // Storing the final result for a sentence in SpellCheckResults
        storeSpellCheckAnalysis();
        // Clearing the contents of data-structures which were used to for Spell Check
        // analysis
        clearContents();
    }

    /**
     * Reads the accepatble words from the input file storing acceptable words
     * 
     * @param inFileName - File name for acceptable words file
     * @throws IOException                            - Exception occured during I/O
     *                                                operations
     * @throws InvalidAccptbleWrdsFileFormatException - Exception occured due to
     *                                                invalid data format present in
     *                                                acceptable words file
     */
    private void processAcceptableWordsFromFile(String inFileName)
            throws IOException, InvalidAccptbleWrdsFileFormatException {
        fileProcessor = new FileProcessor(inFileName);

        while ((line = fileProcessor.readLine()) != null) {
            validatrUtilObj.validateAcceptableWrdsFileData("Acceptable Words file data error",
                    validatrFetchrObj.acceptbleWrdsFileFormatValidn(line));
            acceptableWrdsLst.add(line);
        }
        fileProcessor.closeFile();
    }

    /**
     * Performs spell check analysis on a sentence which is wrapped in element
     * 
     * @param element - ElementI interface for MyElement instance
     */
    private void performSpellCheckAnalysis(ElementI element) {
        wordIterator = element.getIterator();
        // Iteraing through words in a sentence
        while (wordIterator.hasNext()) {
            wrongWrd = "";
            word = ((String) wordIterator.next()).trim().toLowerCase();
            // Iterating through acceptable words
            for (String accepatbleWrd : acceptableWrdsLst) {

                accepatbleWrd = accepatbleWrd.toLowerCase();
                // Checks if the word can be used for performing spell check
                if (word.length() > 2 && !word.equals(accepatbleWrd) && word.length() == accepatbleWrd.length()) {
                    int charMisMatchCount = 0;
                    for (int i = 0; i < word.length(); i += 1) {
                        if (word.charAt(i) != accepatbleWrd.charAt(i)) {
                            charMisMatchCount += 1;
                        }
                        if (charMisMatchCount > 1) {
                            break;
                        }
                    }
                    if (charMisMatchCount == 1) {
                        wrongWrd = word;
                        spellCheckWrdsLst.add(accepatbleWrd);
                    }
                }

            }
            // Storing the output for a word in a sentence in a temporary results list
            if (spellCheckWrdsLst.size() > 0) {
                spellCheckResultsLst.add(wrongWrd + "::" + spellCheckWrdsLst.toString() + "\n");
                spellCheckWrdsLst.clear();
            }

        }
    }

    /**
     * Stores the result of spell check for a particular sentence
     */
    private void storeSpellCheckAnalysis() {
        for (String result : spellCheckResultsLst) {
            spellCheckAnalysisResults.storeResults(result);
        }
    }

    /**
     * Clearing the contents of data-structures
     */
    private void clearContents() {
        spellCheckWrdsLst.clear();
        word = "";
        wrongWrd = "";
        line = "";
        spellCheckResultsLst.clear();
    }

    @Override
    public String toString() {
        return "Class: SpellCheckAnalyzer, DataMembers: [ spellCheckAnalysisResults:"
                + spellCheckAnalysisResults.toString() + ", fileProcessor: " + fileProcessor.toString()
                + ", acceptableWrdsLst: " + acceptableWrdsLst.toString() + ", spellCheckWrdsLst: "
                + spellCheckWrdsLst.toString() + ", spellCheckResultsLst: " + spellCheckResultsLst.toString()
                + ", wordIterator: " + wordIterator.toString() + ", wrongWrd: " + wrongWrd + ", line: " + line
                + ", word: " + word + ", validatrUtilObj: " + validatrUtilObj.toString() + ", validatrFetchrObj: "
                + validatrFetchrObj.toString() + "]";
    }

}