package maxKVisitors.util;

import java.util.List;
import java.util.Vector;

/**
 * @author Snigdha & Pratik
 *
 */
public class MyVector implements MyADT {

	List<Integer> myVect = new Vector<Integer>();

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
		myVect.add(num);
	}
	
	/* (non-Javadoc)
	 * @see maxKVisitors.util.MyADT#getList()
	 */
	public List<Integer> getList(){
		return myVect;
	}	
}
