package wordProcessor.visitor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import wordProcessor.element.MyElement;
import wordProcessor.results.ResultsI;
import wordProcessor.util.fileprocess.FileProcessor;
import wordProcessor.util.fileprocess.FileProcessorI;

/**
 * 
 */
public class SpellCheckAnalyzer implements VisitorI {

    // private String fileName = "";
    private ResultsI results;
    private FileProcessorI fileProcessor;
    private ArrayList<String> acceptableWrdsLst = new ArrayList<String>();

    public SpellCheckAnalyzer(String inFileName, ResultsI inResults) throws IOException {
        results = inResults;
        fileProcessor = new FileProcessor(inFileName);
        String line = "";
        while ((line = fileProcessor.readLine()) != null) {
            acceptableWrdsLst.add(line);
        }
        fileProcessor.closeFile();
    }

    @Override
    public void visit(MyElement element) {

        for (String accepatbleWrd : acceptableWrdsLst) {

            accepatbleWrd = accepatbleWrd.trim().toLowerCase();
            Iterator<String> wordIterator = element.getIterator();
            ArrayList<String> spellCheckWrdsLst = new ArrayList<String>();

            while (wordIterator.hasNext()) {

                String word = wordIterator.next().trim().toLowerCase();

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
                        spellCheckWrdsLst.add(word);
                    }
                }

            }

            if (spellCheckWrdsLst.size() > 0) {
                results.storeResults(accepatbleWrd + "::" + spellCheckWrdsLst.toString());
            }

        }

    }

}