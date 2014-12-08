package maxKVisitors.util;

import java.util.List;

import maxKVisitors.util.Logger;

/**
 * @author Snigdha & Pratik
 *
 */
public class ModifiedBubbleSoryVisitor  implements Visitor{	
	
	int k;
	
	public ModifiedBubbleSoryVisitor(){
		Logger.write(1, getClass().getName()+": Constructor is called."+"\n");
	}

	public ModifiedBubbleSoryVisitor(int k){
		this.k=k;
	}	
	
	// for array
	@Override
	public void visit(MyArray mArray) {
		System.out.println("Bubble Sort of Array : ");
		bubbleSort(mArray.getList());
	}
	
	// for vector
	@Override
	public void visit(MyVector mVector) {
		System.out.println("Bubble Sort of Vector : ");
		bubbleSort(mVector.getList());
	}
	
	/**
	 * @param list
	 */
	private void bubbleSort(List<Integer> list) {	
		
		Logger.write(0,"Entire Output is Printed"+"\n");
		
		Integer[] num = new Integer[list.size()]; 
		list.toArray(num);				
		 for (int i = 0; i < num.length; i++) {
		    for (int x = 1; x < num.length - i; x++) {
		        if (num[x - 1] < num[x]) {
		            int temp = num[x - 1];
		            num[x - 1] = num[x];
		            num[x] = temp;
		        	}
		    	}
		  }
		 
		 if(k > num.length){
			 System.out.println("k is greather than size of array/list. Setting k equal to number of elements.");
			 k = num.length;
		 }
		
		 for(int i=0;i<k;i++){
			 System.out.println(num[i]);
		 }
	}	
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(System.getProperty("line.separator"));
		return result.toString();
	}
	
}
