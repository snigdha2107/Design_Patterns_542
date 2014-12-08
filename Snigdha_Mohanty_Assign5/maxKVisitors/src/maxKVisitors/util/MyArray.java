package maxKVisitors.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Snigdha & Pratik
 *
 */
public class MyArray implements MyADT{

	private List<Integer> myArray = new ArrayList<Integer>();
	public int length;
	
	/* (non-Javadoc)
	 * @see maxKVisitors.util.MyADT#accept(maxKVisitors.util.Visitor)
	 */
	public void accept(Visitor visitor){
		visitor.visit(this);
	}

	/* (non-Javadoc)
	 * @see maxKVisitors.util.MyADT#addElement(java.lang.Integer)
	 */
	public void addElement(Integer num){		
		myArray.add(num);
	}
	
	/* (non-Javadoc)
	 * @see maxKVisitors.util.MyADT#getList()
	 */
	public List<Integer> getList(){
		return myArray;
	}
}
