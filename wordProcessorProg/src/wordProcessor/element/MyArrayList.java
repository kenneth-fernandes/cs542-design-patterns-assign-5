package wordProcessor.element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import wordProcessor.element.ElementI;
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

                if (line.indexOf(".") >= 0) {
                    String[] lineArr = line.trim().split("\\.");
                    temp = temp.concat(lineArr[0]);
                    myArrayList.add(new MyElement(temp));
                    if (lineArr.length > 1) {
                        temp = lineArr[1];
                    } else {
                        temp = "";
                    }
                } else {
                    temp = temp.concat(line);
                }
            }

            if (!temp.isEmpty())
                myArrayList.add(new MyElement(temp));

            fileProcessor.closeFile();

            return new Builder();
        }

        public ElementI build() {
            return myArrayListObj;
        }

    }

    @Override
    public void accept(VisitorI visitor) {
        Iterator<ElementI> elemIterator = getIterator();
        while (elemIterator.hasNext()) {
            elemIterator.next().accept(visitor);
        }
    }

    public Iterator<ElementI> getIterator() {
        return myArrayList.iterator();
    }

}