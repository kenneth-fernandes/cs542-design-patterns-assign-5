package wordProcessor.element;

import java.io.IOException;
import java.util.ArrayList;

import wordProcessor.element.ElementI;
import wordProcessor.iterator.ElementsIterator;
import wordProcessor.iterator.IteratorI;
import wordProcessor.util.fileprocess.FileProcessorI;
import wordProcessor.util.validator.ValidatorFetcher;
import wordProcessor.util.validator.ValidatorFetcherI;
import wordProcessor.util.validator.ValidatorUtil;
import wordProcessor.util.validator.ValidatorUtilI;
import wordProcessor.util.validator.exceptions.InvalidInputFileFormatException;
import wordProcessor.visitor.VisitorI;

public class MyArrayList implements ElementI {
    private static MyArrayList myArrayListObj = new MyArrayList();
    private static ArrayList<ElementI> myArrayList = new ArrayList<ElementI>();

    public static class Builder {
        private String line = "";
        private String temp = "";

        public Builder withFileProcessor(FileProcessorI fileProcessor)
                throws IOException, InvalidInputFileFormatException {

            // Stores the interface of ValidatorUtilI for ValidatorUtil instance
            ValidatorUtilI validatrUtilObj = ValidatorUtil.getInstance();
            // Stores the interface of ValidatorFetcherI for ValidatorFetcher instance
            ValidatorFetcherI validatrFetchrObj = ValidatorFetcher.getInstance();

            while ((line = fileProcessor.readLine()) != null) {

                validatrUtilObj.validateInputFileData("Input-file data error",
                        validatrFetchrObj.inputFileFormatValidn(line));

                /*
                 * char[] lineCharArr = line.toCharArray(); for (char lineChar : lineCharArr) {
                 * if (lineChar == '.') { index += 1; } else { temp = String.copyValueOf() } }
                 */

                if (line.indexOf(".") >= 0) {
                    String[] lineArr = line.split("\\.");
                    for (int i = 0; i < lineArr.length - 1; i += 1) {
                        System.out.println(lineArr[i].trim());
                        myArrayList.add(new MyElement(lineArr[i].trim()));
                    }
                    temp = temp.concat(lineArr[lineArr.length - 1]);

                    if (line.indexOf(".") == line.length() - 1) {
                        System.out.println(temp.trim());
                        myArrayList.add(new MyElement(temp.trim()));
                        temp = "";
                    }
                } else {
                    temp = temp.concat(line);
                }
            }

            if (!temp.isEmpty()) {
                System.out.println(temp.trim());
                myArrayList.add(new MyElement(temp.trim()));
            }

            fileProcessor.closeFile();

            return new Builder();
        }

        public ElementI build() {
            return myArrayListObj;
        }

    }

    @Override
    public void accept(VisitorI visitor) {
        IteratorI elemIterator = this.getIterator();
        while (elemIterator.hasNext()) {
            ((ElementI) elemIterator.next()).accept(visitor);
        }
    }

    public IteratorI getIterator() {
        return new ElementsIterator(myArrayList);
    }

}