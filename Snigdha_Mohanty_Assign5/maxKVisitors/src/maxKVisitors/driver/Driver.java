package maxKVisitors.driver;

import maxKVisitors.util.FileProcessor;
import maxKVisitors.util.Logger;
import maxKVisitors.util.MaxHeapVisitor;
import maxKVisitors.util.MyADT;
import maxKVisitors.util.MyArray;
import maxKVisitors.util.MyVector;
import maxKVisitors.util.ReadVisitor;
import maxKVisitors.util.ModifiedBubbleSoryVisitor;

/**
 * @author Snigdha & Pratik
 *
 */
public class Driver {

	public static void main(String args[]){
		
		Logger.strbuild.append("");
		
		Integer k = null;
		
		//Check command line arguments
		if(args.length !=3 ){
			System.out.println("Invalid input aguments");
			System.exit(1);
		}
		
		//Setting inputfile name
		String file = args[0];
		
		try{
			k = Integer.parseInt(args[1]);
			if(k == 0){
				System.out.println("Value of K should be greater than 0.");
				System.exit(1);
			}
		}catch(NumberFormatException e){
			System.out.println("K should be of integer type.");
			System.exit(1);
		}
		
		Logger.write(0,"Entire Output is Printed"+"\n");
		// Setting value of logger
		String dString = args[2];
		int dValue = Integer.parseInt(dString);
		Logger.setDEBUG_VALUE(dValue);
				
		FileProcessor fp = new FileProcessor(file);
	
		MyADT mA1 = new MyArray();		
		MyADT mV1 = new MyVector();
		
		//Read Visitor
		ReadVisitor sV = new ReadVisitor(fp);		
		mA1.accept(sV);
		mV1.accept(sV);
		
		//Max-Heap Visitor
		MaxHeapVisitor mhv = new MaxHeapVisitor(k);		
		mhv.visit((MyArray) mA1);
		mhv.visit((MyVector) mV1);		
		
		//Bubble Sort Visitor
		ModifiedBubbleSoryVisitor sv = new ModifiedBubbleSoryVisitor(k);		
		sv.visit((MyArray) mA1);
		sv.visit((MyVector) mV1);
		
		System.out.println(Logger.strbuild.toString());		
	}	
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(System.getProperty("line.separator"));
		return result.toString();
	}
}
