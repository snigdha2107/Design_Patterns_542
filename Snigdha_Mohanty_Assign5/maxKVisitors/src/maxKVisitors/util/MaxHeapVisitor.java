package maxKVisitors.util;

import java.util.List;

import maxKVisitors.util.Logger;

/**
 * @author Snigdha & Pratik
 *
 */
public class MaxHeapVisitor implements Visitor{
	
	int k;
	
	public MaxHeapVisitor(){	
		Logger.write(1, getClass().getName()+": Constructor is called."+"\n");
	}

	/**
	 * @param k
	 */
	public MaxHeapVisitor(int k){
		this.k=k;
	}
	
	// for array
	@Override
	public void visit(MyArray mArray) {
		System.out.println("Max Heap on Array");
		maxHeap(k,mArray.getList());
	}
	
	// for vector
	@Override
	public void visit(MyVector mVector) {
		System.out.println("Max Heap on Vector");
		maxHeap(k,mVector.getList());
	}
	
	/**
	 * @param k
	 * @param list
	 */
	private void maxHeap(int k,List<Integer> list){
	
		/*MaxHeap mh = new MaxHeap(list,k);
		mh.calcHeapAndPrint();*/
		
	      Heap<Integer> tmp = new Heap<Integer>();
	      //Integer[] a = {7,67,34,23,8,89,7,43,61,3};
	      
	      Integer[] listarr = new Integer[list.size()];
	      list.toArray(listarr);  	      
	      tmp.heapSort(listarr);
	      //System.out.println("Soted elements..");	      
	      //System.out.println(Arrays.toString(listarr));	      
	      //System.out.println("Top K elements..");
	      
	      if(k > listarr.length){
	    	  System.out.println("k is greather than size of array/list. Setting k equal to number of elements.");
	    	  k = listarr.length;
	      }
	      
	      for(int i=0;i<k;i++){
	    	  System.out.println(listarr[i]);
	      }
		
	    
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(System.getProperty("line.separator"));
		return result.toString();
	}
 	

}
