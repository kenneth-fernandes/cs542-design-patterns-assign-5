# CS542: Assignment 4

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
  

2. Data Structures:
    

3. External Materials:
    - N/A

4. Compiling:
    - Follow the instructions as mentioned above.

5. Execute Program:
    - Follow the instruction as mentioned above.

6. Code Working:
 
---

### Academic Honesty statement:

---

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [04/21/2020]
