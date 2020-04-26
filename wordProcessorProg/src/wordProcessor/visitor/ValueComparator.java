package wordProcessor.visitor;

import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;

/**
 * Class implementing the methods of Comparator interface to compare frequency
 * of the words
 */
class ValueComparator implements Comparator<String> {

    Map<String, Integer> wordFrequencyMap = new HashMap<String, Integer>();

    /**
     * Constructor to set word frequency map
     * 
     * @param inWordFreqMap - Word frequency Map object
     */
    public ValueComparator(Map<String, Integer> inWordFreqMap) {
        this.wordFrequencyMap.putAll(inWordFreqMap);
    }

    /**
     * Implemtation of the overriden compare method
     * 
     * @param strVal1 - Key of Word Frequency Map object - String
     * @param strVal2 - Key of Word Frequency Map object - String
     */
    @Override
    public int compare(String strVal1, String strVal2) {

        return wordFrequencyMap.get(strVal1) >= wordFrequencyMap.get(strVal2) ? -1 : 1;
    }
}