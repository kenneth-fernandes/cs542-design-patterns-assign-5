package wordProcessor.visitor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import wordProcessor.element.MyElement;
import wordProcessor.results.ResultsI;

/**
 * 
 */
public class TopKMostFreqAnalyzer implements VisitorI {

    private int kValue;
    private ResultsI results;
    private Map<String, Integer> wrdFreqMap = new HashMap<>();

    public TopKMostFreqAnalyzer(int inKValue, ResultsI inResults) {
        kValue = inKValue;
        results = inResults;
    }

    @Override
    public void visit(MyElement element) {

        Iterator<String> iterator = element.getIterator();
        while (iterator.hasNext()) {

            String word = iterator.next().toLowerCase();

            if (wrdFreqMap.containsKey(word)) {
                wrdFreqMap.put(word, wrdFreqMap.get(word) + 1);
            } else {
                wrdFreqMap.put(word, 1);
            }
        }
        Comparator<String> comparator = new ValueComparator(wrdFreqMap);

        TreeMap<String, Integer> sortedWrdFreqTMap = new TreeMap<String, Integer>(comparator);

        sortedWrdFreqTMap.putAll(wrdFreqMap);

        ArrayList<String> resultLst = new ArrayList<>();
        int counter = 0;
        for (Map.Entry<String, Integer> entry : sortedWrdFreqTMap.entrySet()) {
            if (counter < kValue) {
                resultLst.add(entry.getKey());
                counter += 1;
            } else {
                break;
            }

        }
        results.storeResults(resultLst.toString());

    }

}