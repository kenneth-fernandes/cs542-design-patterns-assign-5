# CS542: Assignment 5

## Name: Kenneth Peter Fernandes

---

Following are the commands and the instructions to run ANT on your project.

#### Note: build.xml is present in wordProcessorProg/src folder.

---

## Instruction to clean:

```commandline
ant -buildfile wordProcessorProg/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

---

## Instruction to compile:

```commandline
ant -buildfile wordProcessorProg/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

---

## Instruction to run:

#### Use the below command to run the program.

```commandline
ant run -buildfile wordProcessorProg/src/build.xml \
-DinputFile="inputFiles/input.txt" \
-DacceptableWordsFile="inputFiles/acceptable_words.txt" \
-Dk=2 \
-DtopKOutputFile="src/BUILD/resultFiles/topk_output.txt" \
-DspellCheckOutputFile="src/BUILD/resultFiles/spellcheck_output.txt"
```

---

## Description:

1. Assumption:
  - Input file is well formatted containing sentences which contains characters 'A-Z', 'a-z', 'space' and 'period(.)'.
  - The last sentence in the Input file if does not ends with a period charater, the application considers it as sentence completion.
  - Acceptable words file is well formatted containing sentences which contains characters 'A-Z', 'a-z', 'new lines - (for reading words line-by-line)')'.

2. Data Structures:
  - Map<String, Integer> - For storing words with frequency count while reading each word.

  - TreeMap<String, Integer> - For storing sorted words with frequency count after passing the above to the Comparator.

  - ArrayList<String> - 
    - For storing acceptable words list.
    - For storing the final Word frequency result for a particular sentence
    - For storing the list of spell check words list for the misspelled word
    - For storing the the final result for Spell check analysis on a particular sentence

- ArrayList<ElementI> - For storing the ArrayList of type ElementI


3. External Materials:
    - N/A

4. Compiling:
    - Follow the instructions as mentioned above.

5. Execute Program:
    - Follow the instruction as mentioned above.

6. Code Working:
  - Each line is read from the input file containing sentences where each sentence is then wrapped into a MyElement object and its interface ElementI is stored into the MyArrayList<ElementI>.
  - Each element is fetched where two visitors, SpellCheckAnalyzer and TopKFrequentWordsAnalyzer, visit each element and perform the operations.
  - While performing each operation, the result is stored the Results (SpellCheck and TopKFrequentWords).
  - Once all the elements are visited, the stored output is persisted to respective output files.
 
---

### Academic Honesty statement:

---

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [04/21/2020]
