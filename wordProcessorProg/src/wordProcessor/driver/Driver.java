package wordProcessor.driver;

import wordProcessor.results.ResultsI;
import wordProcessor.results.SpellCheckResults;
import wordProcessor.results.TopKFreqWordsResults;
import wordProcessor.util.fileprocess.FileProcessor;
import wordProcessor.util.fileprocess.FileProcessorI;
import wordProcessor.visitor.SpellCheckAnalyzer;
import wordProcessor.visitor.TopKMostFreqAnalyzer;
import wordProcessor.visitor.VisitorI;

/**
 * Driver class - The entry point of the program
 * 
 * @author Kenneth Peter Fernandes
 */
public class Driver {
	private static void runAnalysis(FileProcessor fileProcessor, VisitorI... visitors) {
		Element myArrayList = new MyArrayList.Builder().withFileProcessor(fileProcessor).build();

		for (VisitorI visitor : visitors) {
			myArrayList.accept(visitor);
		}
	}

	private static void persistResults(ResultsI analysisResults) {
		for (ResultsI results : analysisResults) {
			results.writeToFile();
		}
	}

	public static void main(String[] args) {
		// TODO command-line args validation.
		// TODO command-line parsing and initialization of following variables.
		// 1. inputFilename.
		// 2. acceptableWordsFilename.
		// 3. k.
		// 4. topKOutputFilename.
		// 5. spellCheckOutputFilename.


		String inputFilename = "";
		String topKOutputFilename = "";
		int k;
		String spellCheckOutputFilename = "";
		String acceptableWordsFilename = "";


		FileProcessorI fileProcessor = new FileProcessor(inputFilename);

		ResultsI topKFreqWordsResults = new TopKFreqWordsResults(topKOutputFilename);
		VisitorI topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(k, topKFreqWordsResults);

		ResultsI spellCheckResults = new SpellCheckResults(spellCheckOutputFilename);
		VisitorI spellCheckAnalyzer = new SpellCheckAnalyzer(acceptableWordsFilename, spellCheckResults);

		runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);

		persistResults(topKFreqWordsResults, spellCheckResults);
	}
}
