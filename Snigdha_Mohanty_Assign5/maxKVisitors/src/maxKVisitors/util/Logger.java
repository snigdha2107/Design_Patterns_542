package maxKVisitors.util;

/**
 * @author Snigdha & Pratik
 *
 */
public class Logger {
	
    private static int DEBUG_VALUE;

    public static StringBuilder strbuild = new StringBuilder();
    
    private Logger(){
		
	}
    
    // accessor and mutator for DEBUG_VALUE

    /**
     * @param dEBUG_VALUE
     */
    public static void setDEBUG_VALUE(int dEBUG_VALUE) {
		DEBUG_VALUE = dEBUG_VALUE;
	}

	/**
	 * @return
	 */
	public static int getDEBUG_VALUE(){
		return DEBUG_VALUE;
	}
	
	// write(...) method 
	
	/**
	 * @param value
	 * @param cName
	 */
	public static void write(int value, String cName){
		
		if(value==DEBUG_VALUE && value!=0)
		{
			Logger.strbuild.append(cName);
		}
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(System.getProperty("line.separator"));
		return result.toString();
	}
}