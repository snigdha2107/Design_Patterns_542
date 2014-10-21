package dTunesStore.util;



/* DIFFERENT DEBUG VALUES PRINT DIFFERENT MESSAGES */

public class Logger
{
    private static int DEBUG_VALUE;
    /**
     * 
     * @return debug value
     */
    public static int getDebugValue()
    {
    	return DEBUG_VALUE;
    }
    /**
     * 
     * @return void
     */
    public static void setDebug_value(int DEBUG_VALUE) {
		if(DEBUG_VALUE<0 || DEBUG_VALUE>4){
			throw new IllegalArgumentException("DEBUG VALUE should from 0 to 4");
		}
		Logger.DEBUG_VALUE = DEBUG_VALUE;
	}


	public String toString() {
		return "Logger []";
	}
	

}
