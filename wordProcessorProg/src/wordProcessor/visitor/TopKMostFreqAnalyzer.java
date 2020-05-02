package wordProcessor.visitor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import wordProcessor.element.ElementI;
import wordProcessor.iterator.IteratorI;
import wordProcessor.results.ResultsI;

/**
 * TopKMostFreqAnalyzer class - Contains implemented methods of VisitorI for
 * finding out the Top K words that are frequent in a sentence
 * 
 * @author - Kenneth Peter Fernandes
 */
public class TopKMostFreqAnalyzer implements VisitorI {
    // Stores the value for displaying to top number of frequent words in a sentence
    private int kValue;
    // Stores the ResultsI interface for TopKFreqWordsResults instance
    private ResultsI topKFreqntWrdsResults;
    // Stores the word frequency data
    private Map<String, Integer> wrdFreqMap = new HashMap<>();
    // Stores the word frequency data based on frequncy count
    private TreeMap<String, Integer> sortedWrdFreqTMap;
    // Stores the final Word frequency result for a particular sentence
    private ArrayList<String> topKFreqntWrdsResultsLst = new ArrayList<>();

    /**
     * TopKMostFreqAnalyzer class constructor: Initializes the topKFreqntWrdsResults
     * and kValue
     * 
     * @param inKValue  - Value for displaying to top number of frequent words in a
     *                  sentence
     * @param inResults - ResultsI interface for TopKFreqWordsResults instance
     */
    public TopKMostFreqAnalyzer(int inKValue, ResultsI inResults) {
        kValue = inKValue;
        topKFreqntWrdsResults = inResults;
    }

    /**
     * Vists the element that contains sentences by each sentence analyzer
     * 
     * @param element - Sentence wrapped into ElementI interface for MyElement
     *                instance
     */
    @Override
    public void visit(ElementI element) {
        // Invoking the function to sort words by frequency
        sortWordsByFrequencyCount(element.getIterator());
        // Invoking the function to store the final analysis result for a sentence
        storeTopKMostFrequentWords();
        // Invoking the function to clear the contents in the data-structures
        clearContents();

    }

    /**
     * Performs sorting of words based on frequency of the words occuring in a
     * sentence
     * 
     * @param wordIterator - Iterator for words list
     */
    private void sortWordsByFrequencyCount(IteratorI wordIterator) {
        // Iterating through each word
        while (wordIterator.hasNext()) {

            String word = ((String) wordIterator.next()).trim().toLowerCase();
            /**
             * Storing the word and frequncy into a HasMap
             */
            if (wrdFreqMap.containsKey(word)) {
                wrdFreqMap.put(word, wrdFreqMap.get(word) + 1);
            } else {
                wrdFreqMap.put(word, 1);
            }
        }
        /**
         * Storing the sorted HashMap of words with frequency
         */
        sortedWrdFreqTMap = new TreeMap<String, Integer>(new ValueComparator(wrdFreqMap));
        sortedWrdFreqTMap.putAll(wrdFreqMap);
    }

    /**
     * Stores the final Top K frequent words result
     */
    private void storeTopKMostFrequentWords() {
        int counter = 0;
        for (Map.Entry<String, Integer> entry : sortedWrdFreqTMap.entrySet()) {
            if (counter < kValue) {
                topKFreqntWrdsResultsLst.add(entry.getKey());
                counter += 1;
            } else {
                break;
            }
        }
        topKFreqntWrdsResults.storeResults(topKFreqntWrdsResultsLst.toString().concat("\n"));
    }

    /**
     * Clears the contents in the data-structures used for finding Top K frequent
     * words in a sentence
     */
    private void clearContents() {
        wrdFreqMap.clear();
        sortedWrdFreqTMap.clear();
        topKFreqntWrdsResultsLst.clear();
    }

    public String toString() {
        return "Class: TopKMostFreqAnalyzer, DataMembers: [ kValue: " + kValue + ", topKFreqntWrdsResults: "
                + topKFreqntWrdsResults.toString() + ",wrdFreqMap: " + wrdFreqMap.toString()
                + " , topKFreqntWrdsResultsLst: " + topKFreqntWrdsResultsLst.toString() + ", topKFreqntWrdsResultsLst: "
                + topKFreqntWrdsResultsLst.toString() + " ]";
    }

}