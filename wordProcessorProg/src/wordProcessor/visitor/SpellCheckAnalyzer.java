package wordProcessor.visitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import wordProcessor.element.MyElement;
import wordProcessor.results.ResultsI;
import wordProcessor.util.fileprocess.FileProcessor;
import wordProcessor.util.fileprocess.FileProcessorI;
import wordProcessor.util.validator.ValidatorFetcher;
import wordProcessor.util.validator.ValidatorFetcherI;
import wordProcessor.util.validator.ValidatorUtil;
import wordProcessor.util.validator.ValidatorUtilI;
import wordProcessor.util.validator.exceptions.InvalidAccptbleWrdsFileFormatException;

/**
 * 
 */
public class SpellCheckAnalyzer implements VisitorI {

    // private String fileName = "";
    private ResultsI results;
    private FileProcessorI fileProcessor;
    private ArrayList<String> acceptableWrdsLst = new ArrayList<String>();
    // Stores the interface of ValidatorUtilI for ValidatorUtil instance
    private ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
    // Stores the interface of ValidatorFetcherI for ValidatorFetcher instance
    private ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();

    public SpellCheckAnalyzer(String inFileName, ResultsI inResults)
            throws IOException, InvalidAccptbleWrdsFileFormatException {
        results = inResults;
        fileProcessor = new FileProcessor(inFileName);
        String line = "";
        while ((line = fileProcessor.readLine()) != null) {
            validatrUtilObj.validateAcceptableWrdsFileData("Acceptable Words file data error",
                    validatrFetchrObj.acceptbleWrdsFileFormatValidn(line));
            acceptableWrdsLst.add(line);
        }
        fileProcessor.closeFile();
    }

    @Override
    public void visit(MyElement element) {

        Iterator<String> wordIterator = element.getIterator();

        while (wordIterator.hasNext()) {
            ArrayList<String> spellCheckWrdsLst = new ArrayList<String>();
            String wrongWrd = "";
            String word = wordIterator.next().trim().toLowerCase();

            for (String accepatbleWrd : acceptableWrdsLst) {

                accepatbleWrd = accepatbleWrd.trim().toLowerCase();
                

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

            if (spellCheckWrdsLst.size() > 0) {
                results.storeResults(wrongWrd + "::" + spellCheckWrdsLst.toString());
            }

        }

    }

}