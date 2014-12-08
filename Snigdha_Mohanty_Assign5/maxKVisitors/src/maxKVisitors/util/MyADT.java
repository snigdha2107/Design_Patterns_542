package maxKVisitors.util;

import java.util.List;

/**
 * @author Snigdha & Pratik
 *
 */
public interface MyADT {	
	public void accept(Visitor visitor);
	public void addElement(Integer num);
	public List<Integer> getList();
}
