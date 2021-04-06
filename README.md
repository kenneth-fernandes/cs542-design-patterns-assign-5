# CS542 - Design Patterns: Assignment 5

## Name: Kenneth Peter Fernandes

---
## Assignment Goal
Implement the visitor pattern to run different analytics on the given input.

Programming Language - You are required to program using Java.
Compilation Method - You are required to use ANT for compilation of code written in Java.

Project Description
The input file contains sentences with characters in the set [a-zA-Z\. ].
A wrapper class MyArrayList stores the sentences read in from the input file, encapsulated in MyElement, in an internal ArrayList.
MyElement represents an Element (from the Visitor pattern) to be visited.
MyArrayList is just a wrapper class that stores an internal ArrayList of elements. The following methods are exposed by MyArrayList.
getIterator() - Returns an iterator to the internal ArrayList.
accept(...) - Accepts a visitor and delegates the accept(...) to each of the elements.
From above, it should be clear that MyArrayList is also an element.
Once the sentences are all stored, the following analytics need to be run. Note that for analytics, the period character '.' and space character are not to be considered as part of a word..
KMostFrequentWords - For each sentence store the top K most frequent words, sorted in non-increasing order of frequency to Results. The value of K will be provided via commandline. Look into PriorityQueues and Comparators. The format to store the result is [most freq word, next most freq word, ... ]. If two words have the same frequency, then either word can be chosen. Word comparison should be case insensitive.
SpellChecker - In a sentence, check whether there is a spelling mistake in any of the constituent words. Note that for the purpose of this assignment, spell checking is simplified and performed on words that have > 2 characters.
A spelling mistake is said to occur if a single character of a word can be replaced to get an "acceptable word". For example, if 'cheek', 'although' and 'cheer' are acceptable words, then the word 'cheep' can be changed to 'cheek' or 'cheer' by replacing a single character.
The acceptable words are provided in a file, the name of which is provided via commandline.
For words that can be changed to acceptable words, store the word and the possible acceptable words in Results.
The format to store the result is word::[acceptable word 1, acceptable word 2, ... ]. So, for the above example, the output would be cheep::[cheek, cheer].
After running analytics, persist the results to the corresponding output files, the names of which will be provided via commandline.

Input:
The following command-line arguments are to be accepted.
-Dinput - Name of the input file containing sentences.
-DacceptableWordsFile - Name of the file containing acceptable words.
-Dk - Max size of the list containing the most frequent words. Must be > 0.
-DtopKOutputFile - Name of the output file to which the top K words are written for each sentence analyzed. So, if there are 5 sentences in the input file, there should be 5 lines in this file.
-DspellCheckOutputFile - Name of the output file to which the possible spelling fixes are written in the previously mentioned format for each word analyzed.

Sample run command:
``
ant -buildfile src/build.xml run \
-Dinput="input.txt" \
-DacceptableWordsFile="acceptable_words.txt" \
-Dk=2 \
-DtopKOutputFile="topk_output.txt" \
-DspellCheckOutputFile="spellcheck_output.txt"
``

Sample input and acceptable words:

input.txt	
```
Mary was walkink down the aisly. She found the blue berries that she was searching for on the way.
```

acceptable_words.txt
```
walking
aisle
was
```

Sample output:

Assuming K = 2, below is the sample output for the sample input given above.
topk_output.txt	
```
[Mary, was]
[She, the]
```

spellcheck_output.txt
```
walkink::[walking]
aisly::[aisle]
way::[was]
```
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
