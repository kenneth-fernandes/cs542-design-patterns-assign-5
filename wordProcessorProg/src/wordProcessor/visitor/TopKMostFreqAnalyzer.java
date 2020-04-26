package wordProcessor.visitor;

import java.util.ArrayList;
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

    public TopKMostFreqAnalyzer(int inKValue, ResultsI inResults) {
        kValue = inKValue;
        results = inResults;
    }

    @Override
    public void visit(MyElement element) {

        Map<String, Integer> wrdFreqMap = new HashMap<>();
        Iterator<String> iterator = element.getIterator();

        while (iterator.hasNext()) {

            String word = iterator.next().trim().toLowerCase();

            if (wrdFreqMap.containsKey(word)) {
                wrdFreqMap.put(word, wrdFreqMap.get(word) + 1);
            } else {
                wrdFreqMap.put(word, 1);
            }
        }

        TreeMap<String, Integer> sortedWrdFreqTMap = new TreeMap<String, Integer>(new ValueComparator(wrdFreqMap));

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