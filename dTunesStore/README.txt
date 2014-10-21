CS542 Design Pattern
FALL 2014
PROJECT 1 

Submission Date: September 30, 2014
e-mail(s): smohant1@binghamton.edu


PURPOSE:

Application of design patterns/principles for a simple Multi-threaded Read and Compare
  application.


PERCENT COMPLETE:

  
  Reason to choose I have done the Hashmap implementation of the MusicStore. 
  This will enable faster read/search performance in almost O(1) time.


FILES:
  
  MusicInfo.java- the elements of a record from dataFile
  Store.java- the interface of data structure that stores data of dataFile
  MusicStore.java- the data structure to store registration data
  Reader.java- the interface to read file
  ReaderFile.java- responsible to read data from files
  Worker.java- the interface to generates multiple threads
  PopulateWorker.java- the file that reads data from dataFile 
  SearchWorker.java- the file that reads data from searchFile with multi-thread
  ExceptionHandler.java- interface that handles exceptions
  Logger.java- the file that debugs code with different debug values
  Driver.java- the driver file
  Results.java- the file that stores the search results
  build.xml- the buildfile
  dataFile- file contains the music information
  searchFile- contains words to be searched


SAMPLE OUTPUT:


  bingsuns2% ant run -Darg0=dataFile -Darg1=3 -Darg2=searchFile -Darg3=4 -Darg4=4
  SOME OUTPUT
  respective CONSTRUCTORS ARE CALLED
  ===========Results from Driver===========
  SEARCH RESULTS
  BUILD SUCCESSFUL
  Total time: 9 seconds
  bingsuns2% 


TO COMPILE:


  Just extract the files and then do a "ant compile".


TO RUN:


  Please run as: ant run -Darg0=<DATAFILE> -Darg1=<SRCHFILE> -Darg2=<THRDNUM1> -Darg3=<DEBUGVALUE> 
  For example:   ant run -Darg0=dataFile Darg1=searchFile -Darg2=5 -Darg3=4


BIBLIOGRAPHY:

 * http://docs.oracle.com/javase/7/docs/api/java/lang/Thread.html
 * http://stackoverflow.com/questions/2444005/how-do-i-make-my-arraylist-thread-safe-another-approach-to-problem-in-java
