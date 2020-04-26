package wordProcessor.driver;

import java.io.FileNotFoundException;
import java.io.IOException;

import wordProcessor.arraylist.MyArrayList;
import wordProcessor.element.ElementI;
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

	private static void runAnalysis(FileProcessorI fileProcessor, VisitorI... visitors) throws IOException {
		ElementI myArrayList = new MyArrayList.Builder().withFileProcessor(fileProcessor).build();

		for (VisitorI visitor : visitors) {
			myArrayList.accept(visitor);
		}
	}

	private static void persistResults(ResultsI... analysisResults) throws IOException {
		for (ResultsI results : analysisResults) {
			results.writeToFile();
		}
	}

	public static void main(String[] args) {
		try {

			String inputFilename = "";
			String topKOutputFilename = "";
			int k = 0;
			String spellCheckOutputFilename = "";
			String acceptableWordsFilename = "";

			final int REQUIRED_NUMBER_OF_ARGS = 5;
			if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${inputFile}"))
					|| (args[1].equals("${acceptableWordsFile}")) || (args[2].equals("${k}"))
					|| (args[3].equals("${topKOutputFile}")) || (args[4].equals("${spellCheckOutputFile}"))) {

				System.err.printf("\nError: Incorrect number of arguments. Program accepts 4 argumnets.");

				System.exit(0);
			} else {

				inputFilename = args[0];
				acceptableWordsFilename = args[1];
				k = Integer.parseInt(args[2]);
				topKOutputFilename = args[3];
				spellCheckOutputFilename = args[4];
			}

			FileProcessorI fileProcessor = new FileProcessor(inputFilename);

			ResultsI topKFreqWordsResults = new TopKFreqWordsResults(topKOutputFilename);
			VisitorI topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(k, topKFreqWordsResults);

			ResultsI spellCheckResults = new SpellCheckResults(spellCheckOutputFilename);
			VisitorI spellCheckAnalyzer = new SpellCheckAnalyzer(acceptableWordsFilename, spellCheckResults);

			runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);

			persistResults(topKFreqWordsResults, spellCheckResults);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
