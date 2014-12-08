CS542 Design Patterns
Fall 2014
PROJECT 5 README FILE

Due Date: Friday, Nov 21st, 2014
Submission Date: Friday, Nov 21st, 2014
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Snigdha Mohanty & Pratik Nikam

PURPOSE:

[
  The purpose of this assignment is to program with visitors.
]

PERCENT COMPLETE:

[
 We believe we have completed 100% of this project.
]

PARTS THAT ARE NOT COMPLETE:

[
 We believe everything is completed.
]

BUGS:

[
  None
]

FILES:

[
	Driver.java
	FileProcessor.java
	FileProcessorIntf.java
	Heap.java
	Logger.java
	MaxHeapVisitor.java
	MyADT.java
	MyArray.java
	MyVector.java
	ReadVisitor.java
	ReadVisitor.java
	ModifiedBubbleSortVisitor.java
	Visitor.java
	
]

SAMPLE OUTPUT:

[ 
bingsuns2% ant -Darg0=input.txt -Darg1=5 -Darg2=0 run
Buildfile: build.xml

jar:

run:
     [java] Max Heap on Array
     [java] 10
     [java] 9
     [java] 8
     [java] 7
     [java] 6
     [java] Max Heap on Vector
     [java] 10
     [java] 9
     [java] 8
     [java] 7
     [java] 6
     [java] Bubble Sort of Array :
     [java] 10
     [java] 9
     [java] 8
     [java] 7
     [java] 6
     [java] Bubble Sort of Vector :
     [java] 10
     [java] 9
     [java] 8
     [java] 7
     [java] 6


BUILD SUCCESSFUL
]

TO COMPILE:

[
 1. Extract the tarball.
 2. Go into maxKVisitors project directory.
 3. ant compile
]

TO RUN:

[
  Please run as: ant -Darg0=input.txt -Darg1=5 -Darg2=0 run
  Debug Value 0 : Print Entire output.
  Debug Value 1 : Print called constructors with output.
]

EXTRA CREDIT:

[
  Created input file generator in PHP.
  It is located in util folder. 
  infoGenerator.php & inputGenerator.txt
]

GROUP CONTRIBUTION :
[

	File Processor and ReadVisitor written by Pratik
	MaxHeapVisitor & SortingVisitor written by Snigdha
	Rest files we wrote by sitting together
]

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
Snigdha Mohanty & Pratik Nikam

[ 
In previous version of Max-Heap we used priority queue but later on we changes our implementation.
* http://vikkiandtheweb.wordpress.com/2013/09/04/simulating-maxheap-and-minheap-in-java-using-priorityqueue/
 > A priority queue is already a heap, so it does not need a heapify method. This method is usually implemented on structures which are not heaps.
   So just add/remove elements to/from your queue and just assume you have the max elements at position 0 (at the root).
* http://www.cs.cmu.edu/~adamchik/15-121/lectures/Binary%20Heaps/heaps.html
* http://www.kriblog.com/j2se/util/various-bubble-sort-example-in-java-using-string-array-arraylist-linked-list-recursive.html
 
]

ACKNOWLEDGEMENT:

[
  listserv helped us a lot.
]