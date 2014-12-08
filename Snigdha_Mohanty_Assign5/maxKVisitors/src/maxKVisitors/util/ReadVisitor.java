package maxKVisitors.util;

import maxKVisitors.util.Logger;

/**
 * @author Snigdha & Pratik
 *
 */
public class ReadVisitor implements Visitor{
	
	public static int counter;

	private FileProcessor filep;
	public ReadVisitor(FileProcessor file){		
		this.filep = file;
		Logger.write(1, getClass().getName()+": Constructor is called."+"\n");
	}

	// for array
	@Override
	public void visit(MyArray mArray) {		
		Integer num= null;		
		filep.openFile();
		while((num=filep.nextInt())!=null){		
			mArray.addElement(num);	
			counter++;
		}
	}
	
	// for vector
	@Override
	public void visit(MyVector mVector) {		
		Integer num= null;
		filep.openFile();
		while((num=filep.nextInt())!=null){	
			mVector.addElement(num);	
		}		
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(System.getProperty("line.separator"));
		return result.toString();
	}
}
