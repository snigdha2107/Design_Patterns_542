CS542/442 Design Patterns
Fall 2014
PROJECT 3 README FILE


Due Date:  Tuesday, November 4, 2014
Submission:Tuesday, November 4, 2014

Author(s): Snigdha Mohanty
e-mail(s): smohant1@binghamton.edu

PURPOSE:

The purpose of this project was to create a binary search tree that is based on a list of numbers in an input file. I also implemented observer pattern to facilitate calling a few methods on the multiple binary search trees.


PERCENT COMPLETE:

I believe I have completed 100% of this project.


PARTS THAT ARE NOT COMPLETE:

None


BUGS:

None


FILES:

There are many files in this project.

bst/
---- BST.java, the structure and functions for a binary search tree
---- Node.java, structure of a node with getters and setters

observer/
---- Observer -interface to update  
---- Subject - interface to registerobserver ,removeobserver and notifyobservers about the change in some update value.

operations/
Operation- interface
sum- prints the sum of all B numbers in the three trees.
update-to update all nodes in the main BST with UPDATE_VALUE.
util/
---- BSTBuilder.java - Parse through the input file and create a BST

driver/
---- Driver.java - parses the arguments and runs the code




SAMPLE OUTPUT:

ant run -Darg0="bstInput.txt" -Darg1=200

    [mkdir] Created dir: /Users/snigdhamohanty/Desktop/Snigdha_Mohanty/studentRecordsBackup/build/jar
      [jar] Building jar: /Users/snigdhamohanty/Desktop/Snigdha_Mohanty/studentRecordsBackup/build/jar/studentRecordsBackup.jar

run:
     [java] 
     [java] Main Tree inorder traversal
     [java] 17	30	40	42	57	73	77	79	81	87	94	95	99	101	112	119	134	135	174	201	208	229	247	265	267	268	272	287	296	298	
     [java] 
     [java] Backup1 inorder traversal
     [java] 17	30	40	42	57	73	77	79	81	87	94	95	99	101	112	119	134	135	174	201	208	229	247	265	267	268	272	287	296	298	
     [java] 
     [java] Backup2 inorder traversal
     [java] 17	30	40	42	57	73	77	79	81	87	94	95	99	101	112	119	134	135	174	201	208	229	247	265	267	268	272	287	296	298	
     [java] 
     [java] Sum = 4484
     [java] 
     [java] 
     [java] Sum = 4484
     [java] 
     [java] 
     [java] Sum = 4484
     [java] 
     [java] Main Tree inorder traversal
     [java] 217	230	240	242	257	273	277	279	281	287	294	295	299	301	312	319	334	335	374	401	408	429	447	465	467	468	472	487	496	498	
     [java] 
     [java] Backup1 inorder traversal
     [java] 217	230	240	242	257	273	277	279	281	287	294	295	299	301	312	319	334	335	374	401	408	429	447	465	467	468	472	487	496	498	
     [java] 
     [java] Backup2 inorder traversal
     [java] 217	230	240	242	257	273	277	279	281	287	294	295	299	301	312	319	334	335	374	401	408	429	447	465	467	468	472	487	496	498	
     [java] 
     [java] Sum = 10484
     [java] 
     [java] 
     [java] Sum = 10484
     [java] 
     [java] 
     [java] Sum = 10484

BUILD SUCCESSFUL
Total time: 1 second

TO COMPILE:

Run ant-compile in the studentRecordsBackup directory (the same level as build.xml).


TO RUN:

ant run -DinputFileName=<inputFileName> -DupdateValue=<updateValue>

inputFileName must be a valid file and updateValue must be an integer.


EXTRA CREDIT:

N/A

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.

<Snigdha Mohanty>
[
	Complete code is written by me
]

ACKNOWLEDGEMENT:
[
	javaworld.com
	http://stackoverflow.com
]