package wordProcessor.driver;

import java.io.IOException;

import wordProcessor.element.ElementI;
import wordProcessor.element.MyArrayList;
import wordProcessor.results.ResultsI;
import wordProcessor.results.SpellCheckResults;
import wordProcessor.results.TopKFreqWordsResults;
import wordProcessor.util.fileprocess.FileProcessor;
import wordProcessor.util.fileprocess.FileProcessorI;
import wordProcessor.util.validator.ValidatorFetcher;
import wordProcessor.util.validator.ValidatorFetcherI;
import wordProcessor.util.validator.ValidatorUtil;
import wordProcessor.util.validator.ValidatorUtilI;
import wordProcessor.util.validator.exceptions.InvalidAccptbleWrdsFileFormatException;
import wordProcessor.util.validator.exceptions.InvalidInputFileFormatException;
import wordProcessor.util.validator.exceptions.InvalidInputParamsException;
import wordProcessor.visitor.SpellCheckAnalyzer;
import wordProcessor.visitor.TopKMostFreqAnalyzer;
import wordProcessor.visitor.VisitorI;

/**
 * Driver class - The entry point of the program
 * 
 * @author Kenneth Peter Fernandes
 */
public class Driver {
	/**
	 * The functions runs the analysis of finding top K most frequent words and
	 * checking spelling of the words
	 * 
	 * @param fileProcessor - The FileProcessorI interface for FileProcessor
	 *                      instance of input sentences file
	 * @param visitors      - Array of visitors each performing sentence analysis
	 * @throws IOException                     - Exception caused during I/O
	 *                                         operations
	 * @throws InvalidInputFileFormatException - Exception caused by invalid input
	 *                                         file format
	 */
	private static void runAnalysis(FileProcessorI fileProcessor, VisitorI... visitors)
			throws IOException, InvalidInputFileFormatException {
		ElementI myArrayList = new MyArrayList.Builder().withFileProcessor(fileProcessor).build();

		for (VisitorI visitor : visitors) {
			myArrayList.accept(visitor);
		}
	}

	/**
	 * 
	 * @param analysisResults - Array of results each persisting the results for
	 *                        sentence processing anaylysis
	 * @throws IOException - Exception caused during I/O operations
	 */
	private static void persistResults(ResultsI... analysisResults) throws IOException {
		for (ResultsI results : analysisResults) {
			results.writeToFile();
		}
	}

	public static void main(String[] args) {
		try {

			// Stores the interface of ValidatorUtilI for ValidatorUtil instance
			ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
			// Stores the interface of ValidatorFetcherI for ValidatorFetcher instance
			ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();
			/**
			 * Input parameter variables intialization
			 */
			String inputFilename = "", topKOutputFilename = "", spellCheckOutputFilename = "",
					acceptableWordsFilename = "";
			int k = 0;

			/**
			 * Validtion of input parameters from the commandline
			 */
			final int REQUIRED_NUMBER_OF_ARGS = 5;
			if ((args.length != REQUIRED_NUMBER_OF_ARGS) || (args[0].equals("${inputFile}"))
					|| (args[1].equals("${acceptableWordsFile}")) || (args[2].equals("${k}"))
					|| (args[3].equals("${topKOutputFile}")) || (args[4].equals("${spellCheckOutputFile}"))) {

				System.err.printf("\nError: Incorrect number of arguments. Program accepts 4 argumnets.");

				System.exit(0);
			} else {

				validatrUtilObj.validateInputParameters("Input-Parameters Error",
						validatrFetchrObj.filePathValidation(args[0]), validatrFetchrObj.filePathValidation(args[1]),
						validatrFetchrObj.kValueValidation(args[2]), validatrFetchrObj.filePathValidation(args[3]),
						validatrFetchrObj.filePathValidation(args[4]));
				/**
				 * Storing the validated input parameters
				 */
				inputFilename = args[0];
				acceptableWordsFilename = args[1];
				k = Integer.parseInt(args[2]);
				topKOutputFilename = args[3];
				spellCheckOutputFilename = args[4];
			}
			// FileProcessor instance for reading sentences from the input file
			FileProcessorI fileProcessor = new FileProcessor(inputFilename);

			// TopKFreqWordsResults instance for storing and persisting Top K Words
			// Frequency results to output file
			ResultsI topKFreqWordsResults = new TopKFreqWordsResults(topKOutputFilename);
			// The visitor object TopKMostFreqAnalyzer for analyzing the Top K Words
			// frequency
			VisitorI topKMostFreqAnalyzer = new TopKMostFreqAnalyzer(k, topKFreqWordsResults);

			// SpellCheckResults instance for storing and persisting words spell check
			// results to output file
			ResultsI spellCheckResults = new SpellCheckResults(spellCheckOutputFilename);
			// The visitor object SpellCheckAnalyzer for analyzing the Words spell check
			VisitorI spellCheckAnalyzer = new SpellCheckAnalyzer(acceptableWordsFilename, spellCheckResults);
			//
			runAnalysis(fileProcessor, topKMostFreqAnalyzer, spellCheckAnalyzer);
			//
			persistResults(topKFreqWordsResults, spellCheckResults);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (InvalidInputParamsException | InvalidInputFileFormatException
				| InvalidAccptbleWrdsFileFormatException e) {
			System.out.println(e.getMessage());
		}
	}
}
