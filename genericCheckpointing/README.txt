CS542 Design Patterns
Fall 2014
PROJECT <4> README FILE

Due Date: <Monday 15, Decemeber, 2014>
Submission Date: <Monday 15, Decemeber, 2014>
Author(s): <Snigdha Mohanty>
e-mail(s): <smohant1@binghamton.edu>

PERCENT COMPLETE:
[
  I believe we have completed the project 100%, we have implemented entire functionality.
  According to the specific required two design patterns are applied 
  1. proxy  pattern 2. Strategy Pattern.
]

PARTS THAT ARE NOT COMPLETE:
[
  None.
]

BUGS:
[
	Known bugs N/A  
]

FILES:
[
  	Driver.java 			Driver class that calls Invoke handler to the createProxy() utility method,also driver class will call compare method which will compare the returned object with the one that was serialized for specific Instance
	DeSerialize             Interface for XMLDeSerialize
	MSerialize.java 		Interface for XMLSerialize class
	XMLDeSerialize.java 	DeSerialize class that uses reflection to generate classes and calls respective methodfrom the parsed data		
	XMLSerialize            Serialize class that Serialize data and generate checkpoint.txt   
	MyAllTypesFirst.java 	MyAllTypeFirst class
	MyAllTypesSecond.java 	MyAllTypesSecond class
	ReStoreI                This interface will be derived from StoreRestoreI and will have readObj method which will be implemented to deserialize contents from file.
	StoreI       			 This interface will be derived from StoreRestoreI and will have writeObj method which will be implemented to serialize contents to file.
	StoreRestoreI			This is our tag interface for dynamic proxy 
	StoreRestoreHandler		This is a handler class which will have operations to open and close file and the invoke method will be use to serialize and deserialize objects 
	ProxyCreator			ProxyCreator utility class to create a dynamic proxy reference
	SerializableObject		Empty abstract class
	build.xml				Code for ANT compilation and for setting command line arguments.
	README					The text file that you are currently reading.
    checkpoint.txt			Get Format
]

SAMPLE OUTPUT:

[

ant Darg0=ser run
genericCheckpointing:
    [javac] /Users/snigdhamohanty/Desktop/genericCheckpointing/build.xml:37: warning: 'includeantruntime' was not set, defaulting to build.sysclasspath=last; set to false for repeatable builds

compile:

jar:

run:
     [java] Vector serialized to file
     
     Then checkpoint.txt is generated where we can modify some values 
     
     ant -Darg0=deser run
     compile:

jar:

run:
     [java] Desearialization, No of mismatched objects->0
     [java] File desrialized to below list--
     [java] [MyAllTypesFirst [myInt=10, myString=TestStringFirst10, myDouble=3.34, myLong=6, myChar=a], MyAllTypesFirst [myInt=20, myString=TestStringFirst20, myDouble=13.34, myLong=16, myChar=b], MyAllTypesFirst [myInt=30, myString=TestStringFirst30, myDouble=23.34, myLong=26, myChar=c], MyAllTypesFirst [myInt=40, myString=TestStringFirst40, myDouble=33.34, myLong=36, myChar=d], MyAllTypesFirst [myInt=50, myString=TestStringFirst50, myDouble=43.34, myLong=46, myChar=e], MyAllTypesFirst [myInt=60, myString=TestStringFirst60, myDouble=53.34, myLong=56, myChar=f], MyAllTypesFirst [myInt=70, myString=TestStringFirst70, myDouble=63.34, myLong=66, myChar=g], MyAllTypesFirst [myInt=80, myString=TestStringFirst80, myDouble=73.34, myLong=76, myChar=h], MyAllTypesFirst [myInt=90, myString=TestStringFirst90, myDouble=83.34, myLong=86, myChar=i], MyAllTypesFirst [myInt=100, myString=TestStringFirst100, myDouble=93.34, myLong=96, myChar=j], MyAllTypesSecond [myInt=110, myString=TestStringSecond110, myDouble=13.34, myLong=16, myChar=k], MyAllTypesSecond [myInt=120, myString=TestStringSecond120, myDouble=113.34, myLong=116, myChar=l], MyAllTypesSecond [myInt=130, myString=TestStringSecond130, myDouble=123.34, myLong=126, myChar=m], MyAllTypesSecond [myInt=140, myString=TestStringSecond140, myDouble=133.34, myLong=136, myChar=n], MyAllTypesSecond [myInt=150, myString=TestStringSecond150, myDouble=143.34, myLong=146, myChar=o], MyAllTypesSecond [myInt=160, myString=TestStringSecond160, myDouble=153.34, myLong=156, myChar=p], MyAllTypesSecond [myInt=170, myString=TestStringSecond170, myDouble=163.34, myLong=166, myChar=q], MyAllTypesSecond [myInt=180, myString=TestStringSecond180, myDouble=173.34, myLong=176, myChar=r], MyAllTypesSecond [myInt=190, myString=TestStringSecond190, myDouble=183.34, myLong=186, myChar=s], MyAllTypesSecond [myInt=200, myString=TestStringSecond200, myDouble=193.34, myLong=196, myChar=t]]

ant -Darg0=serdeser run
run:
     [java] No of mismatched objects->0
     [java] Comparing serialized and esereialized objects, are they equal->true

BUILD SUCCESSFUL
Total time: 1 second
]

TO COMPILE:

[
  Extract the project and go to the directory(using CD Command) where you have extracted the project.
  
  Please Compile as: ant compile
  
]

TO RUN:

[
  Please run as: ant -Darg0=2 run

]

EXTRA CREDIT:

[

Used Proper proxy pattern

Used Strategy pattern

serialization,deserialization and comparison is working correct

Overriden toString() in every class 

NULL checks are done whenever required

Overriden equals and hashcode method while comparing unique Instances

Program to Interface and not to concrete class

Input validation with user defined Exception handling

]

BIBLIOGRAPHY:

This serves as evidence that we are in no way intending Academic Dishonesty.
<Snigdha Mohanty>
[
	javaworld.com
	http://stackoverflow.com
]

ACKNOWLEDGEMENT:
[
	During the coding process one or more of the following people may have been
  consulted. Their help is greatly appreciated.

  Prof. Madhusudhan Govindaraju
]